-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 06, 2023 at 02:47 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`username`, `password`) VALUES
('denisha', '130'),
('nadya', '196'),
('sani', '044'),
('timot', '121');

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `id` int(11) NOT NULL,
  `renter` varchar(50) NOT NULL,
  `vehicles_id` int(11) NOT NULL,
  `rent_from` datetime NOT NULL DEFAULT current_timestamp(),
  `rent_due` datetime NOT NULL,
  `return_date` datetime DEFAULT NULL,
  `cost` int(11) NOT NULL,
  `fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`id`, `renter`, `vehicles_id`, `rent_from`, `rent_due`, `return_date`, `cost`, `fine`) VALUES
(1, 'Sani', 10, '2023-07-04 14:56:42', '2023-07-05 14:56:42', '2023-07-04 14:57:01', 60000, 0),
(2, 'Denisha', 2, '2023-07-04 14:59:34', '2023-07-04 20:59:34', '2023-07-04 15:00:13', 18000, 0),
(3, 'Timot', 11, '2023-07-04 15:00:54', '2023-07-06 15:00:54', '2023-07-04 15:01:09', 336000, 0),
(4, 'Nadya', 3, '2023-07-04 15:02:15', '2023-07-04 21:02:15', '2023-07-05 19:10:27', 33000, 72600),
(5, 'Denisha', 7, '2023-07-04 15:31:36', '2023-07-06 15:31:36', '2023-07-05 21:29:27', 576000, 0),
(6, 'Timot', 8, '2023-07-04 15:31:47', '2023-07-05 03:31:47', '2023-07-04 15:32:24', 144000, 0),
(7, 'Sani', 9, '2023-07-04 15:31:59', '2023-07-07 15:31:59', NULL, 792000, 0),
(8, 'Nadya', 8, '2023-07-06 00:55:42', '2023-07-06 06:55:42', '2023-07-06 10:04:23', 72000, 21600);

-- --------------------------------------------------------

--
-- Table structure for table `vehicles`
--

CREATE TABLE `vehicles` (
  `id` int(11) NOT NULL,
  `vehicle` enum('Bike','Car') NOT NULL,
  `brand` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `license` varchar(10) NOT NULL,
  `cost` int(11) NOT NULL,
  `available` enum('Yes','No') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vehicles`
--

INSERT INTO `vehicles` (`id`, `vehicle`, `brand`, `type`, `license`, `cost`, `available`) VALUES
(2, 'Bike', 'Honda', 'Scoopy', 'A1234XY', 3000, 'Yes'),
(3, 'Bike', 'Vespa', 'Sprint', 'D553Z', 5500, 'Yes'),
(4, 'Car', 'Toyota', 'Avanza', 'AB888KK', 10000, 'Yes'),
(7, 'Car', 'Suzuki', 'Ertiga', 'AB567SS', 12000, 'Yes'),
(8, 'Car', 'Hyundai', 'Creta', 'D66XYZ', 12000, 'Yes'),
(9, 'Car', 'Daihatsu', 'Ayla', 'F9213GH', 11000, 'No'),
(10, 'Bike', 'Honda', 'Beat', 'A1165BC', 2500, 'Yes'),
(11, 'Bike', 'Kawasaki', 'Ninja', 'B112TK', 7000, 'Yes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `rent`
--
ALTER TABLE `rent`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vehicles_id` (`vehicles_id`);

--
-- Indexes for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `license` (`license`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `rent`
--
ALTER TABLE `rent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `vehicles`
--
ALTER TABLE `vehicles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rent`
--
ALTER TABLE `rent`
  ADD CONSTRAINT `rent_ibfk_1` FOREIGN KEY (`vehicles_id`) REFERENCES `vehicles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
