create database NguyenDaiPhat_Lab9
use NguyenDaiPhat_Lab9

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
	MaKH int not null,
	MaSach int not null,
	NgayMua date not null,
	DonGia int not null,
	Soluong int not null
)

alter table Sach add constraint pk_masach primary key(MaSach) 
alter table KhachHang add constraint pk_MaKH primary key(MaKH)
alter table SachBan add
    constraint pk_SoHD primary key(SoHD),
	constraint fk_MaKH foreign key(MaKH) references KhachHAng(MaKH),
	constraint fk_MaSach foreign key(MaSach) references Sach(MASach) 
alter table SachBan add constraint fk_MaKH foreign key(MaKH) references KhachHAng(MaKH)

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
select* from Sachban
