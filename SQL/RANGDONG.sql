create database RangDong

use RangDong

create table Sach(
    MaSach int not null identity,
	TenSach varchar(50),
	TacGia varchar(50),
	NhaXB varchar(50),
	ChuDe varchar(50),
	DonGia int,
	TrongKHo int
)

create table KhachHang(
    MAKH int not null unique identity,
	TenKH varchar(50) not null,
	DiaChi varchar(50) not null,
	Quan varchar(50) not null,
	DienThoai int not null,
	NguoiGT varchar(50)
)

create table SachBan(
    SoHD int not null identity,
	MaKH int,
	MaSach int ,
	NgayMua date ,
	DonGia int ,
	Soluong int
)

alter table Sach add constraint pk_masach primary key(MaSach) 
alter table KhachHang add constraint pk_MaKH primary key(MaKH)
alter table SachBan add
    constraint pk_SoHD primary key(SoHD),
	constraint fk_MaKH foreign key(MaKH) references KhachHAng(MaKH),
	constraint fk_MaSach foreign key(MaSach) references Sach(MASach) 

insert Sach values
     ('Hoang hon tren song', ' Gia Phong', 'Van hoa', 'Tinh yeu', 120, 11),
	 ('Cay lua nuoc', 'Le May', 'KHKT', 'Khoa Hoc', 30, 24),
	 ('Tam ly truoc mua thi', 'Hai Dang', 'Giao Duc', 'Tam ly', 42, 32)

insert KhachHang values
    ('Le Cong', '22 Hang Buom', 'Hoan Kiem',098123654, 'Hoang Kim'),
	('Van Nghe', '19 Lo Duc', 'Hoan Kiem', 012356789, null),
	('Tran Thong', '19 Doi Can', 'Ba Dinh', 025124124,null),
	('Hoang Tin', '38 Linh Nam', 'Hoang Mai', 056231345, null)

insert SachBan values
    (1,2,'11/22/2006',30,5),
	(1,3,'07/15/2005',40,4),
	(2,1,'05/24/2006',50,7),
	(3,1,'11/15/2005',20,9)
select*from Sach

select* from Sachban

select*from KhachHang

--2.a
select NhaXB, count(TenSach) from Sach 
where NhaXB like 'KHKT' group by NhaXB
--2.b
select NhaXB, count(TenSach) from Sach group by NhaXB order by NhaXB
--2.c
select TenKH, TenSach from Sach a join SachBan b on a.MaSach = b.MaSach join KhachHang c on c.MAKH = b.MaKH
where Quan like 'Ba Dinh'
--2.d
select TenKH, sum(soluong) from KhachHang a join SachBan b on a.MAKH = b.MaKH
group by TenKH
--2.e
select TenKH, NhaXB from KhachHang a join SachBan b on a.MAKH = b.MaKH join Sach c on c.MaSach = b.MaSach
--2.f
select TenKH, count(b.MaKH) from KhachHang a join SachBan b on a.MAKH = b.MaKH
group by TenKH
--2.g
select Quan, sum(SoLuong*DonGia)[GiaTri] from KhachHang a join SachBan b on a.MAKH = b.MaKH
group by Quan 
--2.h
create proc pr_sach(@number varchar(50)) as
begin
  if(exists(select *from Sach where TenSach like @number))
    select* from Sach where TenSach like @number
  else print 'not found'
end

pr_sach 'Hoang hon tren song'
--2.i
create trigger tgUpdateMaSach on Sach instead of update as
   if(update(MaSach)) 
   begin
     alter table SachBan drop constraint fk_MaSach
	 alter table Sach drop constraint pk_masach
	 update Sach set MaSach=(select MaSach from inserted) where MaSach = (select MaSach from deleted)
	 update SachBan set MaSach=(select MaSach from inserted) where MaSach = (select MaSach from deleted) 
	 alter table SachBan add constraint fk_MaSach1 foreign key (MaSach) references Sach(MaSach)
   end

--2.k

create trigger tgDeleteKhachHAng on KhachHang instead of delete as
if 




