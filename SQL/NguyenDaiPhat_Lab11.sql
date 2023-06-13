create database Nguyen_Dai_Phat_Lab11
use Nguyen_Dai_Phat_Lab11

create table Students(
	StudentID int primary key identity,
	Name varchar(50),
	Age tinyint,
	stGender bit
)

create table Books(
	BookID int primary key identity,
	Name varchar(50),
	ToTalPage int,
	Type varchar(10),
	Quantity int,
)

create table Borrows(
    BorrowID int primary key,
	studentID int,
	BookID int, 
	BorrowDate datetime
	constraint fk_1 foreign key(StudentID) references Students(StudentID),
	constraint fk_2 foreign key(BookID) references Books(BookID)
)
create table ReturnBooks(
	ReturnID int primary key identity(1,1),
	StudentID int,
	BookID int,
	Borrowdate datetime,
	ReturnDate datetime,
)

alter table Books add constraint ck_1 check(TotalPage>0)

insert Students values 
	('Henry', 25, 1),
	('Britney', 20, 0),
	('Beckham', 16, null),
	('Madona', 17, 0),
	('Effenberg', 30,1)

insert Books values 
	('Acess 2K', 100, null, 3),
	('Logic C', 60,null, 4),
	('Html', 200, null,2),
	('Core Java' , 50, null, 1),
	('SQL 2K', 1000, null, 6)

insert Borrows values 
	(1,1,5,'09/15/07'),
	(2,2,2,'09/14/07'),
	(3,2,3,'09/20/07'),
	(4,2,1,'09/16/07'),
	(5,2,1,'09/16/07'),
	(6,3,4,'09/19/07'),
	(7,4,4,'09/21/07')

--1
update books set Type = case 
    when TotalPage < 100 then 'Thin'
	when TotalPage <=1000 then 'Normal'
	else 'Thick'
end
--2
select* from Students order by Age 
--3
select top(1) with ties Name from Students order by Age desc
--4
select sum(Quantity) from Books
--5
select Name from Students where stGenDer is null

--6
select Name from Students where Name like 'B%'
--7
select bookID, borrowdate 
--9
insert ReturnBooks select a.studentid, b.bookid, b.borrowdate, getdate()
from Students a join Borrows b on a.StudentID = b.studentID join Books c on b.BookID = c.BookID
where a.name= 'Henry' and c.name= 'SQL 2k'
select * from ReturnBooks
