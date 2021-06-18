-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2021 at 02:35 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hris`
--

-- --------------------------------------------------------

--
-- Table structure for table `t_absen`
--

CREATE TABLE `t_absen` (
  `id` int(11) NOT NULL,
  `jam_masuk` time NOT NULL,
  `jam_keluar` time NOT NULL DEFAULT current_timestamp(),
  `tanggal` date NOT NULL,
  `status` enum('WFO','WFH') NOT NULL,
  `job_desc` text NOT NULL DEFAULT ' ',
  `pegawai_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_absen`
--

INSERT INTO `t_absen` (`id`, `jam_masuk`, `jam_keluar`, `tanggal`, `status`, `job_desc`, `pegawai_id`) VALUES
(1, '07:21:59', '16:05:59', '2021-04-01', 'WFO', '', 1),
(2, '07:42:59', '17:11:59', '2021-04-02', 'WFO', '', 1),
(3, '08:03:21', '16:03:21', '2021-04-05', 'WFO', '', 1),
(4, '07:49:21', '16:53:21', '2021-04-06', 'WFO', '', 1),
(7, '07:54:37', '17:04:37', '2021-04-07', 'WFO', '', 1),
(8, '07:34:37', '16:04:37', '2021-04-08', 'WFO', '', 1),
(9, '07:07:14', '17:36:14', '2021-04-09', 'WFO', '', 1),
(10, '07:16:14', '16:16:14', '2021-04-12', 'WFO', '', 1),
(11, '07:19:00', '16:19:00', '2021-04-13', 'WFO', '', 1),
(12, '07:59:00', '16:22:00', '2021-04-14', 'WFO', '', 1),
(13, '07:21:25', '16:21:25', '2021-04-15', 'WFO', '', 1),
(14, '07:26:25', '16:31:25', '2021-04-16', 'WFO', '', 1),
(15, '08:00:24', '16:02:24', '2021-04-19', 'WFO', '', 1),
(16, '06:59:24', '17:22:24', '2021-04-20', 'WFO', '', 1),
(17, '07:25:10', '16:25:10', '2021-04-21', 'WFO', '', 1),
(18, '06:25:10', '17:25:10', '2021-04-22', 'WFO', '', 1),
(19, '06:49:24', '16:00:24', '2021-04-23', 'WFO', '', 1),
(20, '17:56:24', '16:16:24', '2021-04-26', 'WFO', '', 1),
(21, '07:21:59', '16:19:00', '2021-04-27', 'WFO', '', 1),
(22, '07:42:59', '16:16:14', '2021-04-28', 'WFO', '', 1),
(23, '07:07:14', '16:05:59', '2021-04-29', 'WFO', '', 1),
(24, '07:34:37', '17:11:59', '2021-04-30', 'WFO', '', 1),
(25, '00:46:28', '02:13:44', '2021-06-06', 'WFO', 'Input data', 2),
(26, '01:55:15', '02:13:44', '2021-06-06', 'WFO', 'Input data', 2),
(27, '01:59:38', '02:13:44', '2021-06-06', 'WFO', 'Input data', 2),
(28, '02:08:10', '02:13:44', '2021-06-06', 'WFO', 'Input data', 2),
(29, '02:13:19', '02:13:44', '2021-06-06', 'WFO', 'Input data', 2),
(30, '07:39:56', '16:39:56', '2021-03-01', 'WFO', ' Rapat Pimpinan', 1),
(31, '06:39:56', '17:39:56', '2021-06-02', 'WFO', ' Menghadiri acara Seminar', 1),
(32, '17:14:06', '17:19:12', '2021-06-07', 'WFH', 'Distribusi Surat', 1),
(33, '17:19:12', '17:19:12', '2021-06-07', 'WFH', 'Distribusi Surat', 1);

-- --------------------------------------------------------

--
-- Table structure for table `t_akun_pegawai`
--

CREATE TABLE `t_akun_pegawai` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_akun_pegawai`
--

INSERT INTO `t_akun_pegawai` (`id`, `username`, `password`) VALUES
(1, 'hris1', 'hris1'),
(2, 'hris2', 'hris2'),
(3, 'hris3', 'hris3'),
(4, 'hris4', 'hris4'),
(5, 'hris5', 'hris5'),
(6, 'hris6', 'hris6'),
(7, 'hris7', 'hris7'),
(8, 'hris8', 'hris8'),
(9, 'hris9', 'hris9'),
(10, 'hris10', 'hris10'),
(11, 'hris11', 'hris11'),
(12, 'hris12', 'hris12'),
(13, 'hris13', 'hris13'),
(14, 'hris14', 'hris14'),
(15, 'hris15', 'hris15');

-- --------------------------------------------------------

--
-- Table structure for table `t_cuti`
--

CREATE TABLE `t_cuti` (
  `id` int(11) NOT NULL,
  `pegawai_id` int(11) NOT NULL,
  `tanggal_mulai` date NOT NULL,
  `tanggal_akhir` date NOT NULL,
  `pengganti_id` int(11) NOT NULL,
  `pengganti_nama` varchar(50) NOT NULL,
  `keterangan` text NOT NULL,
  `status` enum('MENUNGGU','SETUJU','BATAL') NOT NULL DEFAULT 'MENUNGGU'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_cuti`
--

INSERT INTO `t_cuti` (`id`, `pegawai_id`, `tanggal_mulai`, `tanggal_akhir`, `pengganti_id`, `pengganti_nama`, `keterangan`, `status`) VALUES
(1, 12, '2021-04-05', '2021-04-06', 8, 'Dwi Reynaldi Nurizal', 'Acara Keluarga', 'SETUJU'),
(2, 9, '2021-04-16', '2021-04-16', 3, 'Aldi Rasta Adrian', 'Istri Melairkan', 'SETUJU'),
(3, 8, '2021-04-21', '2021-04-21', 2, 'Amelia Nur  Kholifah', 'Sakit', 'SETUJU'),
(4, 6, '2021-04-01', '2021-04-02', 10, 'Dennis Fajaria Rusmeidi', 'Persiapan Pernikahan', 'SETUJU'),
(5, 11, '2021-04-19', '2021-04-19', 4, 'Ida Parida', 'Sakit', 'SETUJU'),
(6, 2, '2021-04-15', '2021-04-16', 12, 'Refi Juliansyah', 'Acara Keluarga', 'SETUJU'),
(7, 1, '2021-04-06', '2021-05-06', 3, 'Aldi Rasta Adrian', 'Sakit', 'SETUJU'),
(8, 7, '2021-04-02', '2021-04-02', 4, 'Ida Parida', 'Acara Keluarga', 'SETUJU'),
(9, 2, '2021-06-24', '2021-06-25', 8, 'Dwi Reynaldi Nurizal', 'Acara Keluarga', 'MENUNGGU'),
(10, 2, '2021-06-24', '2021-06-26', 8, 'Dwi Reynaldi Nurizal', 'Sakit', 'MENUNGGU'),
(11, 2, '2021-06-16', '2021-06-18', 12, 'Refi Juliansyah', 'Acara Keluarga', 'MENUNGGU');

-- --------------------------------------------------------

--
-- Table structure for table `t_departemen`
--

CREATE TABLE `t_departemen` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `deskripsi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_departemen`
--

INSERT INTO `t_departemen` (`id`, `nama`, `deskripsi`) VALUES
(1, 'Marketing', ''),
(2, 'Sales', ''),
(3, 'Operator', ''),
(5, 'Accounting', ''),
(6, 'Tax', ''),
(8, 'Network', ''),
(9, 'System', ''),
(10, 'R&D', '');

-- --------------------------------------------------------

--
-- Table structure for table `t_gaji`
--

CREATE TABLE `t_gaji` (
  `id` int(11) NOT NULL,
  `pegawai_id` int(11) NOT NULL,
  `nominal` bigint(20) NOT NULL,
  `bulan` varchar(20) NOT NULL,
  `created_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_gaji`
--

INSERT INTO `t_gaji` (`id`, `pegawai_id`, `nominal`, `bulan`, `created_at`) VALUES
(1, 3, 3500000, 'Mei', '2021-05-01 02:20:27'),
(2, 2, 4000000, 'Mei', '2021-05-01 02:20:27'),
(3, 10, 3200000, 'Mei', '2021-05-01 02:21:21'),
(4, 8, 3200000, 'Mei', '2021-05-01 02:21:21'),
(5, 4, 3500000, 'Mei', '2021-05-01 02:22:13'),
(6, 9, 4000000, 'Mei', '2021-05-01 02:22:13'),
(7, 5, 3500000, 'Mei', '2021-05-01 00:19:31'),
(8, 6, 4000000, 'Mei', '2021-05-01 02:22:44'),
(9, 7, 3500000, 'Mei', '2021-05-01 02:23:30'),
(10, 1, 2800000, 'Mei', '2021-05-01 02:23:30');

-- --------------------------------------------------------

--
-- Table structure for table `t_lembur`
--

CREATE TABLE `t_lembur` (
  `id` int(11) NOT NULL,
  `pegawai_id` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `total_jam` int(11) NOT NULL,
  `bulan` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `t_pegawai`
--

CREATE TABLE `t_pegawai` (
  `id` int(11) NOT NULL,
  `akun_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `nip` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_ktp` varchar(20) NOT NULL,
  `jen_kel` enum('Laki-Laki','Perempuan','','') NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL DEFAULT current_timestamp(),
  `agama` varchar(25) NOT NULL DEFAULT ' ',
  `email` varchar(50) NOT NULL,
  `no_telp` varchar(20) NOT NULL,
  `alamat` text NOT NULL,
  `gol_darah` enum('A','A+','B','B+','O','O+') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_pegawai`
--

INSERT INTO `t_pegawai` (`id`, `akun_id`, `role_id`, `dept_id`, `nip`, `nama`, `no_ktp`, `jen_kel`, `tempat_lahir`, `tanggal_lahir`, `agama`, `email`, `no_telp`, `alamat`, `gol_darah`) VALUES
(1, 1, 1, 8, 43502427, 'Muhammad Quraisy', '3201132104980010', 'Laki-Laki', 'Bogor', '2021-06-06', 'Islam', 'taboobadah.a@gmail.com', '087880688799', 'Jl Warung Buncit Raya 22,Pejaten Barat', 'O+'),
(2, 2, 2, 1, 43502013, 'Amelia Nur  Kholifah', '3201132202990010', 'Perempuan', 'Jakarta', '2021-06-06', 'Islam', '6ahme@gmail.com', '081292923419', 'Jl. Poltangan Raya 22, Ps. Minggu', 'A+'),
(3, 3, 1, 3, 43502013, 'Aldi Rasta Adrian', '3201150606960010', 'Laki-Laki', '', '2021-06-06', ' ', 'kabb@gmail.com', '087880688799', 'Jl Mampang Prapatan XI D-1,Mampang Prapatan', 'B'),
(4, 4, 2, 5, 43502012, 'Ida Parida', '3201131305990010', 'Perempuan', '', '2021-06-06', ' ', '6hamza.mangad.52t', '081292923419', 'Jl MH Thamrin Kav 28-30 Plaza Indonesia Lt 2/25-26', 'B'),
(5, 5, 2, 2, 43502422, 'Muhammad Bayhaqi', '320113204280010', 'Laki-Laki', '', '2021-06-06', ' ', 'vanish2chanx@gmail.com', '087880688799', 'Jl Jend Sudirman Kav 10-11 Midplaza 2,Karet Tengsin', 'B+'),
(6, 6, 2, 10, 43502011, 'Muhammad Dhafa Ramadhan', '320113122990010', 'Laki-Laki', '', '2021-06-06', ' ', 'qayoub.dakhla.359@gmail.com', '081292923419', 'Jl MH Thamrin 9 Menara Cakrawala Lt 5,Kebon Sirih', 'O'),
(7, 7, 2, 6, 43502441, 'Muhammad Helmi Sanjaya', '3201132032480010', 'Laki-Laki', '', '2021-06-06', ' ', 'rbrahim@gmail.com', '087880688799', '623/1 (3td & 4th Floor) Begum Rokeya Sarani', 'B+'),
(8, 8, 2, 1, 43502323, 'Dwi Reynaldi Nurizal', '320113122920010', 'Laki-Laki', '', '2021-06-06', ' ', 'mmohameddrakol@gmail.com', '081292923419', 'Jl HR Rasuna Said Kav 2-3 Bl X-5 Menara Kadin Indonesia Lt 11 R 1', 'O'),
(9, 9, 2, 3, 43502010, 'M. Sandy Rizki Irmawan', '3201132104980011', 'Laki-Laki', '', '2021-06-06', ' ', '8calvin.i@gmail.com', '087880688799', 'Jl MH Thamrin Kav 28-30 Plaza Indonesia Lt 3 52-54', 'B'),
(10, 10, 2, 10, 43502111, 'Dennis Fajaria Rusmeidi', '3201130212980010', 'Laki-Laki', '', '2021-06-06', ' ', 'qmahdi.che@gmail.com', '081292923419', 'Jl MH Thamrin Kav 28-30 Plaza Indonesia Lt 3 56', 'B+'),
(11, 11, 2, 5, 43502426, 'Muhammad Rifqi Pratama', '3201131202990011', 'Laki-Laki', '', '2021-06-06', ' ', '6shri@gmail.com', '087880688799', 'Jl Kb Kacang Mall A Grand Indonesia Bl B Lt 2/1', 'B'),
(12, 12, 2, 1, 43502222, 'Refi Juliansyah', '3201130211980010', 'Laki-Laki', '', '2021-06-06', ' ', '5nine010925353s', '081292923419', 'Kompl Griya Pelita Asri Yadara 1-A,Caturnunggal', 'B');

-- --------------------------------------------------------

--
-- Table structure for table `t_reimburse`
--

CREATE TABLE `t_reimburse` (
  `id` int(11) NOT NULL,
  `pegawai_id` int(11) NOT NULL,
  `nominal` bigint(20) NOT NULL,
  `status` enum('SETUJU','MENUNGGU','BATAL') NOT NULL DEFAULT 'MENUNGGU',
  `created_at` datetime NOT NULL DEFAULT current_timestamp(),
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_reimburse`
--

INSERT INTO `t_reimburse` (`id`, `pegawai_id`, `nominal`, `status`, `created_at`, `keterangan`) VALUES
(1, 1, 150000, 'SETUJU', '2021-03-15 04:11:35', 'Klaim Berobat'),
(2, 1, 80000, 'SETUJU', '2021-02-08 04:11:35', 'Pembayaran Bahan Bakar Kendaraan Perusahaan'),
(3, 6, 3500000, 'SETUJU', '2021-03-25 04:12:33', 'Pembelian Alat Tulis Kantor Perusaahn'),
(4, 8, 120000, 'SETUJU', '2021-04-21 04:12:33', 'Pembelian Bahan Bakar Kendaraan Perusahaan'),
(5, 3, 2500000, 'SETUJU', '2021-04-04 04:16:53', 'Pembelian Tiket Pesawat Untuk Keperluan Dinas'),
(6, 2, 75000, 'SETUJU', '2021-03-29 04:16:53', 'Klaim Berobat'),
(7, 9, 200000, 'SETUJU', '2021-04-14 04:18:06', 'Pembelian Konsumsi Rapat'),
(8, 7, 65000, 'SETUJU', '2021-03-08 04:18:06', 'Pembelian Bahan Bakar Kendaraan Perusahaan'),
(9, 9, 500000, 'SETUJU', '2021-03-15 04:19:49', 'Pembelian Konsumsi Rapat'),
(10, 5, 350000, 'SETUJU', '2021-01-12 04:19:49', 'Pembelian Tiket Kereta Untuk Perjalanan Dinas'),
(11, 1, 500000, 'MENUNGGU', '2021-06-06 00:53:09', 'Klaim Berobat'),
(12, 2, 120000, 'MENUNGGU', '2021-06-07 17:41:23', 'Pembelian Bahan Bakar Mobil Dinas');

-- --------------------------------------------------------

--
-- Table structure for table `t_role`
--

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL,
  `role_nama` varchar(30) NOT NULL,
  `deksripsi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `t_role`
--

INSERT INTO `t_role` (`id`, `role_nama`, `deksripsi`) VALUES
(1, 'Administrator', 'Administrator'),
(2, 'Staff', 'Staff');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `t_absen`
--
ALTER TABLE `t_absen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pegawai_id` (`pegawai_id`);

--
-- Indexes for table `t_akun_pegawai`
--
ALTER TABLE `t_akun_pegawai`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `t_cuti`
--
ALTER TABLE `t_cuti`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pegawai_id` (`pegawai_id`),
  ADD KEY `pengganti_id` (`pengganti_id`),
  ADD KEY `pengganti_nama` (`pengganti_nama`);

--
-- Indexes for table `t_departemen`
--
ALTER TABLE `t_departemen`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `t_gaji`
--
ALTER TABLE `t_gaji`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pegawai_id` (`pegawai_id`);

--
-- Indexes for table `t_lembur`
--
ALTER TABLE `t_lembur`
  ADD KEY `pegawai_id` (`pegawai_id`);

--
-- Indexes for table `t_pegawai`
--
ALTER TABLE `t_pegawai`
  ADD PRIMARY KEY (`id`),
  ADD KEY `akun_id` (`akun_id`,`role_id`,`dept_id`),
  ADD KEY `role_id` (`role_id`),
  ADD KEY `dept_id` (`dept_id`);

--
-- Indexes for table `t_reimburse`
--
ALTER TABLE `t_reimburse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pegawai_id` (`pegawai_id`);

--
-- Indexes for table `t_role`
--
ALTER TABLE `t_role`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `t_absen`
--
ALTER TABLE `t_absen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `t_akun_pegawai`
--
ALTER TABLE `t_akun_pegawai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `t_cuti`
--
ALTER TABLE `t_cuti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `t_departemen`
--
ALTER TABLE `t_departemen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `t_gaji`
--
ALTER TABLE `t_gaji`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `t_pegawai`
--
ALTER TABLE `t_pegawai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `t_reimburse`
--
ALTER TABLE `t_reimburse`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `t_role`
--
ALTER TABLE `t_role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `t_absen`
--
ALTER TABLE `t_absen`
  ADD CONSTRAINT `t_absen_ibfk_1` FOREIGN KEY (`pegawai_id`) REFERENCES `t_pegawai` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `t_cuti`
--
ALTER TABLE `t_cuti`
  ADD CONSTRAINT `t_cuti_ibfk_1` FOREIGN KEY (`pegawai_id`) REFERENCES `t_pegawai` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_cuti_ibfk_2` FOREIGN KEY (`pengganti_id`) REFERENCES `t_pegawai` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `t_gaji`
--
ALTER TABLE `t_gaji`
  ADD CONSTRAINT `t_gaji_ibfk_1` FOREIGN KEY (`pegawai_id`) REFERENCES `t_pegawai` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `t_lembur`
--
ALTER TABLE `t_lembur`
  ADD CONSTRAINT `t_lembur_ibfk_1` FOREIGN KEY (`pegawai_id`) REFERENCES `t_pegawai` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `t_pegawai`
--
ALTER TABLE `t_pegawai`
  ADD CONSTRAINT `t_pegawai_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_pegawai_ibfk_2` FOREIGN KEY (`dept_id`) REFERENCES `t_departemen` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `t_pegawai_ibfk_3` FOREIGN KEY (`akun_id`) REFERENCES `t_akun_pegawai` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `t_reimburse`
--
ALTER TABLE `t_reimburse`
  ADD CONSTRAINT `t_reimburse_ibfk_1` FOREIGN KEY (`pegawai_id`) REFERENCES `t_pegawai` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
