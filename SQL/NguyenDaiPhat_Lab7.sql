create database NguyenDaiPhat_Lab7
use NguyenDaiPhat_Lab7
--3
create table Customer(
    CustomerID int not null,
	Name varchar(30),
	Birth date,
	Gender bit
)

create table Product(
    ProductID int not null,
	Name varchar(30),
	Pdesc text,
	Pimage varchar(200),
	PStatus bit
)

create table Comment(
    ComID int not null identity,
	ProductID int, 
	CustomerID int,
	Date datetime,
	Title varchar(20),
	content text,
	Status bit
)

insert Customer values
    (1,'Jonny Owen', '10/10/1980', 1),
	(2,'Christina Tiny', '03/10/1989',0),
	(3,'Garry Kelley', '03/16/1990',null),
	(4,'Tammy Beckham', '05/17/1980',0),
	(5,'David Phantom', '12/30/1987',1)

insert Product values
    (1, 'Nokia N90', 'Mobie Nokia', 'image1.jgp', 1),
	(2, 'HP DV6000', 'Laptop', 'image2.jgp', null),
	(3, 'HP DVB2000', 'Laptop', 'image3.jgp', 1),
	(4, 'SamSung G488', 'Mobie SamSung' , 'image4.jgp', 0),
	(5, 'LCD Plasma', 'TV LCD', 'image5.jgp', 0)

insert Comment values 
    (1,1,'03/15/09', 'Hot product', null,1),
	(2,2, '03/14/09', 'Hot price', 'Very much', 0),
	(3,2, '03/20/09', 'Cheapest', 'unlimited', 0),
	(4,2, '04/16/09', 'Sale off', '50%', 1)
select*from  Comment

alter table Comment add constraint df_date default (getdate()) for date
alter table Customer add constraint pk1 primary key(CustomerID)
alter table Product add constraint pk2 primary key(ProductID)
alter table Comment add constraint pk3 primary key(ComID)
alter table Comment add constraint fk1 foreign key(ProductID) references Product(ProductID)
alter table Comment add constraint fk2 foreign key(CustomerID) references Customer(CustomerID)
alter table Product add constraint unq1 unique(Pimage)

--4
select Name from Product where PStatus = 0 or Pstatus is null

--5
select Name from Product where ProductID not in (select ProductID from Comment)

--6
select top(1) with ties Name, count(ComID) as [So binh luan] from Customer a join Comment b on
a.CustomerID = b.CustomerID group by Name order by count(ComID) DESC
--7
create view vwFull_Information as
  select b.ComID, a.Name [ten khach], c.Name [ten hang], b.Date, b.Title, b.content,[Status] = case b.[Status]
     when 0 then 'Not Accept'
	 when 1 then 'Accept'
	 else 'Unknow'
	 end
	from Customer a join Comment b on a.CustomerID  = b.CustomerID join Product c on b.ProductID = c.ProductID

select* from vwFull_Information
--8
create view vwCustomerList as
    select CustomerID, Name, Birth, Gender = case gender 
	  when 1 then 'Male'
	  when 0 then 'Female'
	  else 'Unknow' 
	  end,
	[Status]= case 
	  when datediff(yy,birth,getdate()) >=30 then 'Old'
	  when datediff(yy,birth,getdate()) < 30 then 'Young'
	  else 'Unknown' end
	from Customer 

select * from vwCustomerList
--9
alter view vwCustomerlist as 
    select CustomerID, Name[CustomerName], birth, gender from dbo.Customer
create unique clustered index ixCustomerName on vwCustomerList([CustomerName])
--10.
create proc spStudent1(@name varchar(30)) as
begin
	if(exists(select Name from Product where Name like '%' + @name + '%'))
		select a.Name, Date, Title, Content from Product a join Comment b on a.ProductID=b.ProductID where Name like '%' + @name + '%'
	else if(exists(select Name from Customer where Name like '%' + @name + '%'))
		select a.Name, Date, Title, Content from Customer a join Comment b on a.CustomerID=b.CustomerID where Name like '%' + @name + '%'
	else if(@name= '*')
		select Name,Date, title, content from Product a join Comment b  on a.ProductID=b.ProductID   
	else
	print 'Not found!'
end
exec spStudent1 'Jonny Owen'
--11
create trigger tgUpdateProduct on Product instead of update as
  if update (ProductID)
  begin
     alter table Comment drop constraint fk1
	 update Product set ProductID=(select ProductID from inserted) where ProductID = (select ProductID from deleted)
	 update Comment set ProductId=(select ProductID from inserted) where ProductID = (select ProductID from deleted) 
	 alter table Comment add constraint fk1 foreign key (ProductID) references Product(ProductID)
  end

--check
update Product set ProductID = 10 where ProductId=1
select* from Product
Select* from Comment
update Product set ProductID=1 where ProductID=10


--12.
create proc spDropOut(@name varchar(30)) as
begin
	if(exists(select Name from Customer where Name = @name))
	begin
		delete from Comment where CustomerID in(select CustomerID from Customer where Name=@name)
		delete from Customer where Name=@name
	end
	else
	begin
		print 'Cannot found project name'
	end
end
exec spDropOut 'Jonny Own'
