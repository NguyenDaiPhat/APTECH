create database NguyenDaiPhat_Lab6
use NguyenDaiPhat_Lab6
create table Students(
    StudentID int not null identity,
	Name varchar(50),
	Age tinyint,
	stGender bit
)
create table Projects(
    PID int not null identity,
	PName varchar(50),
	Cost float ,
	Type varchar(10)
)

create table StudentProject(
    StudentID int not null,
	PID int not null,
	WorkDate date,
	Duration int
)
--3
insert Students(Name, Age, stGender) values
    ('Joe Hart', 25, 1),
	('Colin Doyle', 20, 1),
	('Paul Robinson', 16, NULL),
	('Ben Foster', 30, 1)

insert Projects(PName, Cost) values
    ('NewYork Bridge', 100),
	('Tenda Road' , 60),
	('Google Road', 200),
	('The Star Bridge', 50)

insert StudentProject values
    (1,4,'05/15/09',3),
	(2,2,'05/14/09',5),
	(2,3,'05/20/09',6),
	(2,1,'05/16/09',4),
	(3,1,'05/16/09',6),
	(3,4,'05/19/09',7),
	(4,4,'05/21/09',8)

--4
alter table Students add constraint ck_age check(age>5 and age<33)
alter table Students add constraint fk_studentid primary key (Studentid)
alter table Projects add constraint fk_PID primary key (pid)
alter table StudentProject add constraint fk_student_project primary key (studentid,pid)
alter table StudentProject add constraint df_duration default (0) for duration
alter table StudentProject add constraint pk_studentid foreign key(studentid) references Students(Studentid)
alter table StudentProject add constraint pk_pid foreign key(PID) references Projects(pid)
--5
update Projects set [Type] = case 
  when Cost < 80 then 'Education'
  when Cost < 150 then 'Normal'
  else 'Goverment'
end
--6
select* from Students a join StudentProject b on a.StudentID= b.StudentID join Projects c on c.PID=b.PID
select Name from Students where StudentID in (select StudentID from StudentProject
group by StudentID having count(PID)>1)

select *from  Students
select* from Projects
select* from StudentProject

--7
select Name from Students where StudentID in (select top(1) with ties StudentID from StudentProject
group by StudentID order by Sum(Duration) desc)

--8
select Name from Students a join StudentProject b on a.StudentID= b.StudentID join Projects c on c.PID=b.PID
where Name like '%Paul%' and PName= 'The Star Bridge'

--9
select Name from Students where StudentID not in (select StudentID from StudentProject)

--10
create view vWStudentProject as
    select top(99.99) percent Name, PName, Workdate, Duration from Students a join StudentProject b on a.StudentID=b.StudentID join Projects c on c.PID=b.PID
    order by Name
exec sp_helptext 'vWStudentProject'
exec sp_depends 'vWStudentProject'
select OBJECT_DEFINITION (object_id('vWStudentProject'))
select * from vWStudentProject
--11
alter view vWStudentProject with encryption, schemabinding as
    select Name, PName, WorkDate Duration from dbo.Students a join dbo.StudentProject b on a.StudentID=b.StudentID join dbo.Projects c on c.PID=b.PID

create unique clustered index ixStudetName on vwStudentProject(Name, Pname)
--12
create proc spWorki (@Name1 varchar(5)) as
 Begin
   if(exists(select* from Students where Name like '%'+@Name1+'%'))
     select Name, PName from Students a join StudentProject b on a.StudentID = b.StudentID join Projects c on c.PID = b.PID
     where Name like '%'+ @Name1 + '%'
   else if( @Name1 = 'any')
     select Name, PName from Students a join StudentProject b on a.StudentID = b.StudentID join Projects c on c.PID = b.PID
   else print N'Không có Sinh viên nào tương tự ' + @Name1
 end
 spWorki 'phat'

 --13
  create trigger tgUpdateTrig on Students instead of update as
    Begin
	   alter table StudentProject drop constraint fk1
	    update Student set StudentID = (select StudentId from inserted) 
		where Studentid=(select StudentID from deleted)
		update StudentProject set StudentID = (select StudentID from inserted)
		where StudentID = (select StudentID from deleted)
		  alter table StudentProject add constraint fk1 foreign key (StudentID)
		  references Students(StudentID)
	End
update Students set StudentID= 6 where StudentID=2

select*from StudentProject

--14
create proc spDropOut (@Pname varchar(50)) as 
 Begin
   if(exists (select*from Projects where Pname like '%'+@PName+ '%'))
   begin
     Delete from StudentProject where PID in (select PID from Projects
	 where Pname like '%' + @PName + '%')
	 Delete from Projects where PNAme like '%' + @PName + '%'
   end
 end

exec spDropOut 'The'
