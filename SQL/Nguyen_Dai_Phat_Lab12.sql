create database Nguyen_Dai_Phat_Lab12
use Nguyen_Dai_Phat_Lab12

create table NhaCungCap(
	MaNhaCC nvarchar(10) not null,
	TenNhaCC nvarchar(40),
	DiaChi nvarchar(60),
	Phone nvarchar(24),
	Fax nvarchar(24),
	HomePage ntext
)

create table KhachHang(
	MaKH nvarchar(10) not null,
	TenKH nvarchar(30),
	DiaChi ntext,
	Phone nvarchar(24),
	Email nvarchar(30)
)
create table NhanVien(
	MaNV nvarchar(10) not null,
	HoTen nvarchar(20),
	ChucDanh nvarchar(30),
	NgaySinh smalldatetime,
	NgayNhanViec smalldatetime,
	DiaChi nvarchar(50),
	Phone nvarchar(20),
	Photo image,
	GhiChu ntext
)
create table LoaiSanPham(
	MaLoaiSP nvarchar(10) not null,
	TenLoaiSP nvarchar(15),
	MoTa ntext
)

create table SanPham(
	MaSP nvarchar(10) not null,
	TenSP nvarchar(40),
	MaNhaCC nvarchar(10),
	MaloaiSP nvarchar(10),
	DVT nvarchar(20),
	DonGia smallint,
	SoLuong Smallint,
	SoLuongTT smallint,
	Discontinued bit
)

create table HoaDon(
	MaHD nvarchar(10) not null,
	MaKH nvarchar(10),
	MaNV nvarchar(10),
	NgayLapHD smalldatetime,
	NgayNhanHang smalldatetime,
	Tien int,
	Thue real,
	TongsoTien int
)

create table HoaDonChiTiet(
	MaHD nvarchar(10),
	MaSP nvarchar(10),
	DonGia int,
	SoLuong smallint,
	GiamGia real, 
	ThanhTien int
)


--primary key
alter table NhaCungCap add constraint pk_1 primary key (MaNhaCC)
alter table LoaiSanPham add constraint pk_2 primary key(MaLoaiSP)
alter table NhanVien add constraint pk_3 primary key (MaNV)
alter table SanPham add constraint pk_4 primary key(MaSp)
alter table HoaDon add constraint pk_5 primary key(MaHD)
alter table KhachHang add constraint pk_6 primary key(MaKH)

--
alter table SanPham add 
	constraint fk_1 foreign key (MaNhaCC) references NhaCungCap(MaNhaCC),
	constraint fk_2 foreign key(MaLoaiSP) references LoaiSanPham(MaLoaiSp)
alter table HoaDonChiTiet add 
	constraint fk_3 foreign key (MaSP) references SanPham(MaSP),
	constraint fk_4 foreign key (MaHD) references HoaDon (MaHD)
alter table HoaDon add
	constraint fk_5 foreign key (MaNV) references NhanVien(MaNv),
	constraint fk_6 foreign key (MaKH) references KhachHang(MaKH)
--
insert NhaCungCap values 
('BAN','Cong ty Ban mai', '64 Hang Bun', '048286745',null,'www.binhminh.com'),
('OCE','Cong ty Ocean', '26 Tran Quy Cap', '048924712', null, 'www.ocean.com')

insert NhaCungCap values
('RDO', 'Cong ty Rang Dong', '97 Hoang Hoa Tham', '048923711', null, 'www.rdong.com')

insert KhachHang values 
('01','Hoa Binh', 'Ha Noi', '0913567222', 'hb@fpt.vn'),
('02','Quang Long','Ha Noi', '048123445', 'qlong@yahoo.com'),
('03','Nguyen Tuan', 'Hai Phong', '098467231', 'Tuan@yahoo.com')

insert NhanVien values 
('01', 'Lan Huong', 'Ban Hang', '11/23/1980', '1/15/2004', 'Hoa Binh', '0912349865', null, null),
('02', 'Bich Hue', 'Tiep Thi', '12/31/1979', '1/22/2001', 'Quang Binh', '098768324', null, null),
('03','Tung Chi', 'Ban Hang', '8/9/1986', '1/14/2005', 'Hai Phong', '098568253', null, null),
('04','Kien Cuong', 'Thu Kho', '9/19/1979', '1/22/2003', 'HaNoi', '0912367299', null,null)

insert LoaiSanPham values 
('DL', 'Dien lanh', null),
('DT', 'Dientu', null),
('MP', 'Hang my pham', null),
('TD', 'Hang tieu dung', null)

insert SanPham values 
('001', 'Vo tuyen' , 'BAN', 'DT', 'Chiec', 4000, 25, 5 ,0),
('002', 'Radio', 'BAN', 'DT', 'Chiec', 200, 150, 20, 0),
('003', 'CD player', 'BAN', 'DT', 'Chiec', 2000, 45, 10, 0),
('004', 'Tu Lanh', 'RDO', 'DL', 'Chiec', 6000, 22, 5, 0),
('005', 'May lam kem', 'RDO', 'DL', 'Chiec', 7000, 19, 4, 0),
('007', 'May dieu hoa', 'RDO', 'DL', 'Chiec', 9000, 38, 7, 0),
('008', 'Xa phong thom', 'OCE', 'TD', 'Banh', 6, 200, 50, 0),
('009', 'Duong', 'OCE', 'TD', 'Kg', 9,550,50,0),
('010', 'Sua', 'OCE', 'TD', 'Hop', 120, 80, 20, 0),
('011', 'Mi miliket', 'OCE', 'TD', 'Thung', 200, 56, 8 , 0)

insert HoaDon values 
('01', '02', '01', '12/14/2007', '1/15/2007', 0, 0.05, 0),
('02', '01', '01', '1/19/2006', '2/15/2006', 0, 0.05,0),
('03', '02', '02', '10/30/2006', '1/1/2006', 0, 0.1, 0)

insert HoaDonChiTiet values 
('03', '003',0, 3, 0.02, 0),
('03', '007', 0, 2, 0.01, 0),
('03', '011', 0, 10, 0 , 0),
('02', '010', 0, 11, 0.04, 0),
('02', '002', 0, 2, 0.01, 0),
('01', '004', 0, 1, 0.05, 0),
('01', '009', 0, 15, 0.04, 0)

--1
update HoaDonChiTiet set ThanhTien = DonGia*SoLuong * (1-GiamGia)
select*from HoaDonChiTiet
--2
update HoaDon set Tien = (select sum(ThanhTien) from HoaDonChiTiet group by MaHD)
where MaHD = (select MaHD from HoaDonChiTiet)


