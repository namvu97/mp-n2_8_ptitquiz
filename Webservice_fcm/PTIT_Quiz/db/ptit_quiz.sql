-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 31, 2019 lúc 07:01 AM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ptit_quiz`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_question`
--

CREATE TABLE `tbl_question` (
  `question_id` int(50) NOT NULL,
  `monhoc` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `made` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `cauhoi` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `answer1` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `answer2` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `answer3` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `answer4` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `answer` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_question`
--

INSERT INTO `tbl_question` (`question_id`, `monhoc`, `made`, `cauhoi`, `answer1`, `answer2`, `answer3`, `answer4`, `answer`) VALUES
(1, 'Mạng máy tính', 'Đề 01', '\"Thuật toán chạy trên gateway router là\"', 'Inter-routing', 'Intra-routing', 'Cả hai đều sai', 'Cả hai đều đúng', 'Cả hai đều đúng'),
(3, 'Mạng máy tính', 'Đề 01', '\"Các mạng máy tính được thiết kế và cài đặt theo quan điểm\"', 'Theo lớp', 'Có cấu trúc đa tầng', 'Tập hợp', 'Nhiều tầng', 'Có cấu trúc đa tầng'),
(5, 'Mạng máy tính', 'Đề 01', '\"IPv6 có không gian địa chỉ là\"', '32 bit', '256 bit', '64 bit', '128 bit', '128 bit'),
(6, 'Mạng máy tính', 'Đề 01', 'Giao thức nào cung cấp tính năng vận chuyển gói tin có độ tin cậy cao', 'IP', 'UDP', 'ARP', 'TCP', 'TCP'),
(7, 'Mạng máy tính', 'Đề 01', '\"Độ dài của khung dữ liệu của ATM là\"', '512 byte', '53 byte', '128 byte', '1500 byte', '53 byte'),
(8, 'Mạng máy tính', 'Đề 01', '\"Chức năng của tầng vật lý là\"', 'Đảm bảo các yêu cầu truyền/nhận các chuỗi bit qua các phương tiện vật lý', 'Kiểm soát lỗi và luồng dữ liệu', 'Tạo khung thông tin', 'Phân mảnh và đóng gói dữ liệu', 'Đảm bảo các yêu cầu truyền/nhận các chuỗi bit qua các phương tiện vật lý'),
(9, 'Mạng máy tính', 'Đề 01', '\"Ứng dụng nào sử dụng mô hình P2P\"', 'Telnet', 'Email', 'Web', 'Skype', 'Skype'),
(10, 'Mạng máy tính', 'Đề 01', '\"Các chuẩn Internet là\"', 'FDM và TDM', 'ACK và NAK', 'RFC và IETF', 'TCP và UDP', 'RFC và IETF'),
(11, 'Mạng máy tính', 'Đề 01', 'Khẳng định nào sau đây là đúng nói về cấu trúc vật lý của mạng', 'Giao thức mạng (Protocol)', 'Hình trạng mạng (Topology)', 'Các dịch vụ mạng', 'Phượng tiện truyền', 'Hình trạng mạng (Topology)'),
(12, 'Mạng máy tính', 'Đề 01', 'IPv4, lớp B có số NetIDs/HostIDs sử dụng tương...', '2^10/(2^22 - 2)', '2^11/(2^21 - 2)', '2^14/(2^16 - 2)', '2^13/(2^19 - 2)', '2^14/(2^16 - 2)'),
(13, 'An toàn bảo mật', 'Đề 02', 'Câu 01', 'A', 'B', 'C', 'D', 'A'),
(14, 'An toàn bảo mật', 'Đề 02', 'Câu 02', 'A', 'B', 'C', 'D', 'A');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_schedule`
--

CREATE TABLE `tbl_schedule` (
  `schedule_id` int(11) NOT NULL,
  `monhoc` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `dethi` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `hinhthuc` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `sinhvien` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_schedule`
--

INSERT INTO `tbl_schedule` (`schedule_id`, `monhoc`, `dethi`, `hinhthuc`, `sinhvien`) VALUES
(16, 'Mạng máy tính', 'Đề 01', 'Trắc nghiệm', 'Sinh viên 2'),
(17, 'Mạng máy tính', 'Đề 01', 'Trắc nghiệm', 'Sinh viên 2'),
(18, 'Mạng máy tính', 'Đề 01', 'Trắc nghiệm', 'Sinh viên 1');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_user`
--

CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL,
  `c_email` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `c_password` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `c_fullname` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tbl_user`
--

INSERT INTO `tbl_user` (`user_id`, `c_email`, `c_password`, `c_fullname`) VALUES
(1, 'admin@gmail.com', '54e193277215c92570bc9659bd48ff40', 'Vũ Phương Nam');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbl_question`
--
ALTER TABLE `tbl_question`
  ADD PRIMARY KEY (`question_id`);

--
-- Chỉ mục cho bảng `tbl_schedule`
--
ALTER TABLE `tbl_schedule`
  ADD PRIMARY KEY (`schedule_id`);

--
-- Chỉ mục cho bảng `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tbl_question`
--
ALTER TABLE `tbl_question`
  MODIFY `question_id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `tbl_schedule`
--
ALTER TABLE `tbl_schedule`
  MODIFY `schedule_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
