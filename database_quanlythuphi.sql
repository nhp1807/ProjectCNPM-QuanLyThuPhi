-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2023 at 04:10 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database_quanlythuphi`
--

-- --------------------------------------------------------

--
-- Table structure for table `danhsachdongphi`
--

CREATE TABLE `danhsachdongphi` (
  `IDKhoanThu` varchar(30) NOT NULL,
  `IDHoKhau` varchar(30) NOT NULL,
  `NguoiDong` varchar(30) DEFAULT NULL,
  `NgayNop` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `danhsachdongphi`
--

INSERT INTO `danhsachdongphi` (`IDKhoanThu`, `IDHoKhau`, `NguoiDong`, `NgayNop`) VALUES
('KT03', 'HK03', 'Phạm Ngọc Hải', '2023-01-18'),
('KT03', 'HK02', 'Nguyễn Duy Thái', '2023-01-21'),
('KT02', 'HK02', 'Nguyễn Khoa Đoàn', '2023-02-01'),
('KT04', 'HK04', 'Nguyễn Xuân Sơn', '2023-02-01');

-- --------------------------------------------------------

--
-- Table structure for table `hokhau`
--

CREATE TABLE `hokhau` (
  `IDHoKhau` varchar(30) NOT NULL,
  `ChuHo` varchar(30) NOT NULL,
  `DiaChi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `hokhau`
--

INSERT INTO `hokhau` (`IDHoKhau`, `ChuHo`, `DiaChi`) VALUES
('HK01', 'Nguyễn Hải Phong', 'Cầu Giấy'),
('HK02', 'Nguyễn Khoa Đoàn', 'Ba Đình'),
('HK03', 'Đỗ Trung Hiếu', 'Hoàng Mai'),
('HK04', 'Nguyễn Xuân Sơn', 'Hai Bà Trung');

-- --------------------------------------------------------

--
-- Table structure for table `khoanthu`
--

CREATE TABLE `khoanthu` (
  `IDKhoanThu` varchar(30) NOT NULL,
  `TenKhoanThu` varchar(30) NOT NULL,
  `LoaiKhoanThu` varchar(30) NOT NULL,
  `GiaTri` int(11) DEFAULT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khoanthu`
--

INSERT INTO `khoanthu` (`IDKhoanThu`, `TenKhoanThu`, `LoaiKhoanThu`, `GiaTri`, `NgayBatDau`, `NgayKetThuc`) VALUES
('KT01', 'Nước', 'Bắt buộc', 10000, '2022-01-15', '2023-01-15'),
('KT02', 'Phí vệ sinh', 'Ủng hộ', 6000, '2023-01-01', '2023-12-31'),
('KT03', 'Điện', 'Bắt buộc', 12000, '2022-09-01', '2024-01-01'),
('KT04', 'Tết 2023', 'Ủng hộ', 50000, '2023-01-01', '2023-01-30'),
('KT05', 'Phí dịch vụ', 'Bắt buộc', 120000, '2023-02-01', '2023-03-01');

-- --------------------------------------------------------

--
-- Table structure for table `nguoidung`
--

CREATE TABLE `nguoidung` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nguoidung`
--

INSERT INTO `nguoidung` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `nhankhau`
--

CREATE TABLE `nhankhau` (
  `IDNhanKhau` varchar(30) NOT NULL,
  `IDHoKhau` varchar(30) DEFAULT NULL,
  `HoTen` varchar(30) DEFAULT NULL,
  `CCCD` varchar(30) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `QuanHeVoiChuHo` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhankhau`
--

INSERT INTO `nhankhau` (`IDNhanKhau`, `IDHoKhau`, `HoTen`, `CCCD`, `NgaySinh`, `QuanHeVoiChuHo`) VALUES
('NK01', 'HK01', 'Nguyễn Hải Phong', '001202007035', '2002-07-18', 'Chủ hộ'),
('NK02', 'HK01', 'Nguyễn Hải Minh', '001202007036', '2013-06-06', 'Em trai'),
('NK03', 'HK02', 'Nguyễn Khoa Đoàn', '001202007034', '2002-05-14', 'Chủ hộ'),
('NK04', 'HK02', 'Nguyễn Duy Thái', '001204007035', '2001-07-18', 'Anh trai'),
('NK05', 'HK03', 'Đỗ Trung Hiếu', '001201207035', '2001-08-21', 'Chủ hộ'),
('NK06', 'HK03', 'Phạm Ngọc Hải', '001202008035', '2009-07-20', 'Em trai'),
('NK07', 'HK04', 'Nguyễn Xuân Sơn', '001202004535', '2002-07-06', 'Chủ hộ'),
('NK08', 'HK04', 'Phạm Thanh Bình', '001202117035', '2000-07-18', 'Anh trai');

-- --------------------------------------------------------

--
-- Table structure for table `quatang`
--

CREATE TABLE `quatang` (
  `IDQuaTang` varchar(30) NOT NULL,
  `SuKien` varchar(30) NOT NULL,
  `BaoGom` varchar(30) NOT NULL,
  `DieuKien` varchar(30) NOT NULL,
  `GiaTri` int(11) NOT NULL,
  `DiaDiemNhanQua` varchar(30) NOT NULL,
  `NgayBatDau` date NOT NULL,
  `NgayKetThuc` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `quatang`
--

INSERT INTO `quatang` (`IDQuaTang`, `SuKien`, `BaoGom`, `DieuKien`, `GiaTri`, `DiaDiemNhanQua`, `NgayBatDau`, `NgayKetThuc`) VALUES
('QT01', 'Tết 2023', '5 bánh trưng, 1 thùng mỳ', 'Hộ hoàn cảnh khó khăn', 550000, 'Phát trực tiếp cho dân', '2023-01-01', '2023-01-01'),
('QT02', 'Chào xuân', 'Lì xì 50000VND', 'Trẻ dưới 18 tuổi', 50000, 'Tổ trưởng phát ', '2023-01-23', '2023-01-23'),
('QT03', 'Học sinh giỏi', '10 quyển vở', 'Đạt học sinh giỏi', 100000, 'Nhà văn hoá', '2023-01-20', '2023-01-20'),
('QT04', 'Học sinh tiên tiến', '7 quyển vở', 'Đạt học sinh tiên tiến', 70000, 'Nhà văn hoá', '2023-01-20', '2023-02-20'),
('QT05', 'Học sinh trung bình', '5 quyển vở', 'Đạt học sinh trung bình', 50000, 'Nhà văn hoá', '2023-01-20', '2023-02-20');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `danhsachdongphi`
--
ALTER TABLE `danhsachdongphi`
  ADD KEY `IDHoKhau` (`IDHoKhau`),
  ADD KEY `IDKhoanThu` (`IDKhoanThu`);

--
-- Indexes for table `hokhau`
--
ALTER TABLE `hokhau`
  ADD PRIMARY KEY (`IDHoKhau`);

--
-- Indexes for table `khoanthu`
--
ALTER TABLE `khoanthu`
  ADD PRIMARY KEY (`IDKhoanThu`);

--
-- Indexes for table `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nhankhau`
--
ALTER TABLE `nhankhau`
  ADD PRIMARY KEY (`IDNhanKhau`),
  ADD KEY `IDHoKhau` (`IDHoKhau`);

--
-- Indexes for table `quatang`
--
ALTER TABLE `quatang`
  ADD PRIMARY KEY (`IDQuaTang`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nguoidung`
--
ALTER TABLE `nguoidung`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `danhsachdongphi`
--
ALTER TABLE `danhsachdongphi`
  ADD CONSTRAINT `danhsachdongphi_ibfk_1` FOREIGN KEY (`IDHoKhau`) REFERENCES `hokhau` (`IDHoKhau`);

--
-- Constraints for table `nhankhau`
--
ALTER TABLE `nhankhau`
  ADD CONSTRAINT `nhankhau_ibfk_1` FOREIGN KEY (`IDHoKhau`) REFERENCES `hokhau` (`IDHoKhau`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
