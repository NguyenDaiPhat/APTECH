create database NGuyenDaiPhat_Lab10
use NguyenDaiPhat_Lab10

exec sp_addType 'myType', 'varchar(50)'


create table Book(
    BookCode int primary key,
	BookTitle mytype,
	Author mytype,
	Edition int,
	BookPrice money,
	Copies int
)


create table Member(
    MemberCode int primary key,
	Name mytype,
	Address mytype,
	PhoneNumber varchar(10)
)

create table IssueDetails(
    BookCode int,
	MemberCode int,
	IssueDate datetime,
	ReturnDate datetime
	constraint fk_1 foreign key(Bookcode) references Book(BookCode),
	constraint fk_2 foreign key(MemberCode) references Member(MemberCode)
)
alter table Book add constraint ck_bookprice check(BookPrice>10)
alter table IssueDetails add IssueID uniqueidentifier
alter table Member alter column PhoneNumber varchar(12)

insert Book values
    (1,'CF', 'Barlow', 3, 12, 5),
	(2,'HTML', 'Parker', 2, 20, 10),
	(3, 'RDBMS', 'Long', 1, 15, 8),
	(4,'EPC', 'Norton', 1, 22, 9),
	(5,'Java by Example','Giles', 2,13,16),
	(6,'Guide to advanced java', 'Harding', 1, 14, 18)

insert Member values
    (1, 'Dam Vinh Hung', 'Quan 1 HCM', '0913123123'),
	(2, 'My Le', 'Quan Thu Duc HCM', '0913123456'),
	(3, 'Kim Tu Long', 'Quan 10 HCM', '0912111222'),
	(4, 'Tai Linh', 'Hue', '0984123456'),
	(5, 'Ung Hoang Phuc', 'Quan 3 HCM', '0913444444'),
	(6, 'My Linh', 'Ba Dinh Ha noi', '0984234432')

insert IssueDetails values 
    (6,1,'10/09/2005','10/20/2005',null),
	(5,2,'1/1/2006', '1/5/2006',null),
	(4,3, '1/10/2006', '1/15/2006',null),
	(3,4,'1/20/2006', '1/25/2006',null),
	(2,5, '2/1/2006', '2/5/2006',null),
	(1,6, '3/1/2006', '3/25/2006',null)

--5
 alter table Member add Gender bit
 update Member set Gender= 1 where membercode =1 or membercode =3 or membercode =4 or membercode = 5
 update Member set Gender= 0 where membercode =2 or membercode =6
 --6a
 select Gender, count(Gender)[Total] from Member group by Gender 
 --6b
select Sum(copies)[Total] from Book 
--6c
select *from Book where BookTitle like '%C%'
--6d
select *from Member where Address like '%HCM%'
--6e
select BookTitle from Book a join IssueDetails b on a.BookCode = b.BookCode
where datename(yy,IssueDate) = 2006 order by a.BookCode
--6f
create unique index unqi1 on Book(BookTitle)
--6g
create view v1 as 
select a.MemberCode, Name, b.BookCode, BookTitle, Author, Edition, BookPrice, Copies from Member a join IssueDetails b on a.MemberCode = b.MemberCode join Book c on c.BookCode = b.BookCode
where Gender = 1

select * from v1
--6h
create proc pr_sach(@Name mytype) as
begin
   if(exists(select Booktitle from Book where BookTitle like @Name))
   select * from Book where BookTitle like @NAme
   else print'Not Found'
end

pr_sach 'F'
--6i
create trigger tg_member on Member instead of delete as
begin
   delete from IssueDetails where memberCode = (select membercode from deleted)
   delete from Member where memberCode = (select membercode from deleted)
end

delete from Member where memberCode = 1
select *from Member
select *from IssueDetails

--6k
create trigger tg_update_bookss on Book instead of update as
begin
   alter table IssueDetails drop constraint fk_1
      update Book set BookCode = (select BookCode from inserted) where BookCode = (select BookCode from deleted)
   update IssueDetails set BookCode = (select BookCode from inserted) where BookCode = (select BookCode from deleted)
   alter table IssueDetails add constraint fk_1 foreign key(BookCode) references Book(Bookcode)
end

update IssueDetails set BookCode =10 where BookCode =1
select*from IssueDetails
select*from Book

