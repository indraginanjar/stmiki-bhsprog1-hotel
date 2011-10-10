-- phpMyAdmin SQL Dump
-- version 3.3.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 10, 2011 at 10:04 AM
-- Server version: 5.1.54
-- PHP Version: 5.3.5-1ubuntu7.2

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dbhotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `tamu`
--

CREATE TABLE IF NOT EXISTS `tamu` (
  `idtamu` int(11) NOT NULL,
  `namatamu` varchar(25) NOT NULL,
  `kamar` varchar(25) NOT NULL,
  PRIMARY KEY (`idtamu`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tamu`
--

INSERT INTO `tamu` (`idtamu`, `namatamu`, `kamar`) VALUES
(1, 'Sodikin', 'VIP'),
(2, 'Samiun', 'Biasa'),
(3, 'Karyono', 'Kiri'),
(4, 'Mulyasari', 'Kanan'),
(5, 'Kamiun', 'Tengah');
