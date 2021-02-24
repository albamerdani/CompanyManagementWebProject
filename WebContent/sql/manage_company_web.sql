-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 10, 2018 at 04:36 PM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manage_company_web`
--

-- --------------------------------------------------------

--
-- Table structure for table `brands`
--

CREATE TABLE `brands` (
  `IdBrand` int(11) UNSIGNED NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Validity` tinyint(1) NOT NULL,
  `IdShop` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `brands`
--

INSERT INTO `brands` (`IdBrand`, `Name`, `Description`, `Validity`, `IdShop`) VALUES
(1, 'Terranova', 'firme veshjesh', 1, 1),
(2, 'IlCamino', 'firme kepucesh', 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `IdCompany` int(10) UNSIGNED NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Nipt` varchar(20) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Validity` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`IdCompany`, `Name`, `Nipt`, `Address`, `Description`, `Validity`) VALUES
(2, 'Toptani', 'T12345678T', 'Tirane', 'pershkrim', 1),
(3, 'TEG', 'T123456789TEG', 'Tirane', 'pershkrim', 1),
(4, 'Tirana RING Center', 'TR123456RING', 'Tirane', 'pershkrim', 1);

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `IdCountry` int(10) UNSIGNED NOT NULL,
  `Country` varchar(30) NOT NULL,
  `Currency` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`IdCountry`, `Country`, `Currency`) VALUES
(1, 'Albania', 'leke'),
(2, 'Italy', 'euro'),
(3, 'USA', 'dollar'),
(4, 'France', 'euro'),
(6, 'Turkey', 'lira');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `IdDep` int(10) UNSIGNED NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Validity` tinyint(3) UNSIGNED NOT NULL,
  `IdCompany` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`IdDep`, `Name`, `Description`, `Validity`, `IdCompany`) VALUES
(1, 'Veshje', 'femra dhe meshkuj', 1, 2),
(2, 'Kepuce', 'femra, meshkuj dhe femije', 1, 3),
(3, 'Make-up', 'kremra, buzekuqe, rimele, penele, lapsa, tone', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `IdRole` tinyint(3) UNSIGNED NOT NULL,
  `Role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`IdRole`, `Role`) VALUES
(1, 'admin'),
(2, 'adminBrand'),
(3, 'adminShop'),
(4, 'adminSector'),
(5, 'adminDepartment'),
(6, 'adminCompany'),
(7, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `sector`
--

CREATE TABLE `sector` (
  `IdSector` int(10) UNSIGNED NOT NULL,
  `Name` varchar(20) NOT NULL,
  `IdDep` int(10) UNSIGNED NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Validity` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sector`
--

INSERT INTO `sector` (`IdSector`, `Name`, `IdDep`, `Description`, `Validity`) VALUES
(1, 'fustane', 1, 'vere dhe me menge', '1'),
(2, 'T-shirt', 1, 'bluza, kemisha', '1'),
(3, 'cizme', 2, 'te shkurtra, te gjata, me qafa, kastor, me pellush', '1'),
(4, 'sandale', 2, 'te sheshta, ortopedike, me taka, per mbremje, me gisht, me rripa', '1'),
(5, 'krem', 3, 'fytyre, duarsh, trupi, flokesh', '1'),
(6, 'buzekuqe', 3, 'shkelqyes, te bute, te forte, te erret, me ngjyra, te celet', '1');

-- --------------------------------------------------------

--
-- Table structure for table `shops`
--

CREATE TABLE `shops` (
  `IdShop` int(11) UNSIGNED NOT NULL,
  `IdCountry` int(11) UNSIGNED NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` double NOT NULL,
  `Description` varchar(200) NOT NULL,
  `Validity` tinyint(3) UNSIGNED NOT NULL,
  `IdSector` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shops`
--

INSERT INTO `shops` (`IdShop`, `IdCountry`, `Quantity`, `Price`, `Description`, `Validity`, `IdSector`) VALUES
(1, 1, 20, 3000, 'pershkrim', 1, 1),
(2, 2, 50, 100, 'pershkrim', 1, 1),
(3, 1, 50, 2500, 'pershkrim', 1, 2),
(4, 3, 80, 15, 'pershkrim', 1, 2),
(5, 4, 15, 3500, 'pershkrim', 1, 3),
(6, 2, 10, 40, 'pershkrim', 1, 4);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `IdUser` int(10) UNSIGNED NOT NULL,
  `Firstname` varchar(15) NOT NULL,
  `Lastname` varchar(15) NOT NULL,
  `Gender` varchar(8) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `Cel` varchar(20) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `IdRole` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`IdUser`, `Firstname`, `Lastname`, `Gender`, `Email`, `Cel`, `Address`, `Username`, `Password`, `IdRole`) VALUES
(1, 'alba', 'merdani', 'femer', 'alba@yahoo.com', '069 xx xx xxx', 'Tirane', 'alba', 'admin', 1),
(2, 'rexhes', 'merdani', 'mashkull', 'rexhes@gmail.com', '069xxxxxxx', 'Elbasan', 'user', 'user', 7);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`IdBrand`),
  ADD KEY `IdShop` (`IdShop`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`IdCompany`),
  ADD UNIQUE KEY `Nipt` (`Nipt`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`IdCountry`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`IdDep`),
  ADD KEY `IdCompany` (`IdCompany`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`IdRole`);

--
-- Indexes for table `sector`
--
ALTER TABLE `sector`
  ADD PRIMARY KEY (`IdSector`),
  ADD KEY `IdDep` (`IdDep`);

--
-- Indexes for table `shops`
--
ALTER TABLE `shops`
  ADD PRIMARY KEY (`IdShop`),
  ADD KEY `IdCountry` (`IdCountry`),
  ADD KEY `IdSector` (`IdSector`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`IdUser`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `Cel` (`Cel`),
  ADD UNIQUE KEY `Email` (`Email`),
  ADD KEY `IdRole` (`IdRole`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `brands`
--
ALTER TABLE `brands`
  MODIFY `IdBrand` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `IdCompany` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `IdCountry` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `department`
--
ALTER TABLE `department`
  MODIFY `IdDep` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `IdRole` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `sector`
--
ALTER TABLE `sector`
  MODIFY `IdSector` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `shops`
--
ALTER TABLE `shops`
  MODIFY `IdShop` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `IdUser` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `brands`
--
ALTER TABLE `brands`
  ADD CONSTRAINT `brands_ibfk_1` FOREIGN KEY (`IdShop`) REFERENCES `shops` (`IdShop`);

--
-- Constraints for table `department`
--
ALTER TABLE `department`
  ADD CONSTRAINT `department_ibfk_1` FOREIGN KEY (`IdCompany`) REFERENCES `company` (`IdCompany`);

--
-- Constraints for table `sector`
--
ALTER TABLE `sector`
  ADD CONSTRAINT `sector_ibfk_1` FOREIGN KEY (`IdDep`) REFERENCES `department` (`IdDep`);

--
-- Constraints for table `shops`
--
ALTER TABLE `shops`
  ADD CONSTRAINT `shops_ibfk_1` FOREIGN KEY (`IdCountry`) REFERENCES `country` (`IdCountry`),
  ADD CONSTRAINT `shops_ibfk_2` FOREIGN KEY (`IdSector`) REFERENCES `sector` (`IdSector`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`IdRole`) REFERENCES `role` (`IdRole`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
