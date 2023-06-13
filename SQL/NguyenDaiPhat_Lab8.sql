--2 
create database DBLab8
use DBLab8
--3

create table Food(
    fID int not null,
	Name varchar(30),
	Price money
)

create table FoodStuff(
    sID int not null,
	Name nvarchar(30),
	Type int
)

create table FoodDetail(
    fID int not null,
	sID int not null
)

alter table Food add constraint pk_fID primary key(fID)
alter table FoodStuff add constraint pk_sID primary key(sID)
alter table FoodDetail add
    constraint pk_fID_sID primary key(fID, sID),
	constraint fk_fID foreign key( fID) references Food(fID),
	constraint fk_sID foreign key( sID) references FoodStuff(sID)

insert Food values
    (1,N'Gà hấp xì dầu', 27000),
	(2,N'Sườn nõn sốt chanh', 33000),
	(3,N'Bò xào hành tỏi', 23000),
	(4,N'Cá thu sốt', 31000)

insert FoodStuff values 
    (1,N'thịt gà', 1),
	(2,N'Thịt Lợn',1),
	(3,N'Thịt bò', 1),
	(4,N'Cá thu', 1),
	(5,N'Hành', 2),
	(6,N'Tỏi',2),
	(7,N'Cà chua', 2),
	(8,N'Xì dầu', 2),
	(9,N'Canh', 2),
	(10,N'Hạt tiêu',2)

insert FoodDetail values
    (1,1),
	(1,8),
	(2,2),
	(2,9),
	(2,7),
	(2,5),
	(3,3),
	(3,5),
	(3,6),
	(4,4),
	(4,7)
--4
select*from Food
select*from FoodStuff
select a.name, c.name from Food a join FoodDetail b on a.fID=b.fID join FoodStuff c on c.sID=b.sID
--5
select * from FoodStuff where sID not in (select sID from FoodDetail)
--6
select a.Name from FoodStuff a join FoodDetail b on a.sID = b.sID join Food c on c.fID = b.fID 
group by a.Name having count(c.Name)>1
--7
select top(1) with ties c.Name from FoodStuff a join FoodDetail b on a.sID = b.sID join Food c on c.fID = b.fID 
group by c.Name order by count(a.Name) desc
--8
select Name, type= case Type
    when 1 then N'Thực Phẩm Chính'
	when 2 then N'Gia vị'
	end
from FoodStuff
--9
create view vw_Foodlist1 as
    select top(99.99) percent * from Food order by Price desc

select * from vw_Foodlist1
--10
update Food set Price= Price *1.1
select*from Food
update Food set Price= Price /1.1
go
select*from Food
--11
create proc sp_FoodChoice(@Name money) as
 begin
     select*from Food where Price < @Name 
 end
go
sp_FoodChoice 30000

--12
alter proc sp_FoodChoice(@Name nvarchar(50), @Type nvarchar(30)) as
 begin
     if(exists(select * from FoodStuff where Name like '%'+ @Name + '%'))
	 begin
	     if( @Type =N'Rẻ')
		 begin
		     select distinct a.Name, Price from Food a join FoodDetail b
			 on a.fID = b.fID join FoodStuff c on b.sID = c.sID
			 where Price <30000 order by Price desc
		 end
		 else if( @Type =N'Đắt')
		  begin
		   select distinct a.Name, Price from Food a join FoodDetail b
		   on a.fID = b.fID join FoodStuff c on b.sID = c.sID
		   where Price>30000 order by Price desc
		  end
		 else if (@Type = '*')
		 begin
		     select Name, Price from Food 
		 end
		 else 
		 begin
		     print N'Không có món ăn nào thỏa mãn'
		 end
	end
   else 
     begin
	   print N'Không có món ăn nào thỏa mãn'
	end
end
	
sp_FoodChoice N'Thịt',N'Rẻ'
--13 
create trigger tg_NoUpdatePrice on Food for update as
 begin
  if(select max(Price) from inserted) >= 40000
   begin
    print N'Giá phải nhỏ hơn 40000'
	rollback tran
   end
 end
update Food set Price = 41000

 --14
create trigger tg_delFood on Food instead of delete as
 begin
  delete from FoodDetail where fID in ( select fID from deleted)
  delete from Food where fID in ( select fID From deleted)
end

select*from FoodDetail
delete from Food where fID = 3
