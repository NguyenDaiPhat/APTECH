-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 06, 2023 lúc 06:39 AM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 7.3.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quản_ly_sách`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `publish` int(11) NOT NULL,
  `price` varchar(100) NOT NULL,
  `number` int(100) NOT NULL,
  `category` varchar(20) NOT NULL,
  `img` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_nopad_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`id`, `name`, `publish`, `price`, `number`, `category`, `img`) VALUES
('qt1', 'CUỐN SÁCH HỒNG ÂN ', 2022, '20000.0', 50, 'NGÔN TÌNH', 'tR5dAzF4ItuYVUI.png'),
('qt10', 'The snowman', 2022, '25000.0', 50, 'CỔ TÍCH', 'Xf8XXjbbcv3muhl.png'),
('qt11', 'THỎA MÁN VỊ GIÁC', 2022, '30000.0', 30, 'VĂN HỌC', 'KsWCzV4ckCCDeLL.png'),
('qt12', 'TO THE MOON', 2022, '40000.0', 20, 'CỔ TÍCH', 'cSPQn3QW4Ld1sOA.png'),
('qt13', 'TÔI ĂN GÌ HÔM NAY', 2020, '30000.0', 10, 'VĂN HỌC', 'g52Z3ZNglhlOHn1.png'),
('qt14', 'VƯỢT VÙNG NƯỚC LỚN', 2018, '20000.0', 30, 'VĂN HỌC', '1KizPQHHSsfvAc7.png'),
('qt2', 'English book', 2022, '40000.0', 100, 'VĂN HỌC', 'ZZhy3BcbiYxl1I4.png'),
('qt3', 'HÃY LÀ CHÍNH MÌNH ', 2022, '50000.0', 50, 'VĂN HỌC', 'betbUZ8yp2oi4HN.png'),
('qt4', 'KIẾN THỨC VĂN TỰ', 2021, '40000.0', 30, 'VĂN HỌC', '6YOAKtSvJ65zVvB.png'),
('qt5', 'MACHIN LEARNING', 2019, '60000.0', 50, 'VĂN HỌC', '1OBHnzocOPtP7Vy.png'),
('qt6', 'MASK', 2022, '60000.0', 30, 'KINH DỊ', 'm8FydkHcYeGuet0.png'),
('qt7', 'NANH TRẮNG', 2020, '40000.0', 50, 'KINH DỊ', 'KBFA5Xf0tP9ecnI.png'),
('qt8', 'NHẬT KÝ NGUYỆN CỦA TÔI ', 2022, '60000.0', 50, 'NGÔN TÌNH', 'O2HE82Bhggh7UPf.png'),
('qt9', 'NỘI GIỚI VÀ NGOẠI GIỚI', 2022, '70000.0', 30, 'TRINH THÁM', 'gnDDs5oUmnn9zg3.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` varchar(50) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` varchar(100) NOT NULL,
  `number` int(100) NOT NULL,
  `total` varchar(100) NOT NULL,
  `inventory` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_id`
--

CREATE TABLE `user_id` (
  `name` varchar(50) COLLATE utf8_vietnamese_ci NOT NULL,
  `age` int(20) NOT NULL,
  `user_name` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(100) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `user_id`
--

INSERT INTO `user_id` (`name`, `age`, `user_name`, `password`) VALUES
('Nguyễn Kỳ Anh', 20, ' Kyanh123', '123'),
('Nguyễn Văn A', 20, 'Kyanh26', '123'),
('Nguyễn Văn Phát ', 20, 'phat123', '123'),
('Ngỗ anh tuấn', 30, 'Tuân26', '123');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user_id`
--
ALTER TABLE `user_id`
  ADD PRIMARY KEY (`user_name`) USING BTREE;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK_book_id` FOREIGN KEY (`id`) REFERENCES `book` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
