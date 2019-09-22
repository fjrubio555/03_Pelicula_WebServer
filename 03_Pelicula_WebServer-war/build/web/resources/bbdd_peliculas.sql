-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 23, 2019 at 07:12 AM
-- Server version: 5.7.24-log
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bbdd_peliculas`
--
CREATE DATABASE IF NOT EXISTS `bbdd_peliculas` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `bbdd_peliculas`;

-- --------------------------------------------------------

--
-- Table structure for table `pelicula`
--

CREATE TABLE `pelicula` (
  `id` int(11) NOT NULL,
  `titulo` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `director` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  `estreno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `pelicula`
--

INSERT INTO `pelicula` (`id`, `titulo`, `director`, `estreno`) VALUES
(1, 'Star Wars: Episodio IV - Una nueva esperanza', 'George Lucas', 1977),
(2, 'Star Wars: Episodio V - El Imperio contraataca', 'Irvin Kershner', 1980),
(3, 'Star Wars: Episodio VI - El regreso del Jedi', 'Richard Marquand', 1983),
(4, 'Star Wars: Episodio I - La amenaza fantasma', 'George Lucas', 1999),
(5, 'Star Wars: Episodio II - El ataque de los clones', 'George Lucas', 2002),
(6, 'Star Wars: Episodio III - La venganza de los Sith', 'George Lucas', 2005),
(7, 'Star Wars: Episodio VII - El despertar de la Fuerza', 'J. J. Abrams', 2015),
(8, 'Star Wars: Episodio VIII - Los últimos Jedi', 'Rian Johnson', 2017),
(9, 'Star Wars: Episodio IX - El ascenso de Skywalker', 'J. J. Abrams', 2019),
(10, 'Matrix', 'Hermanas Wachowski', 1999),
(11, 'Matrix Reloaded', 'Hermanas Wachowski', 2003),
(12, 'Matrix Revolutions', 'Hermanas Wachowski', 2003);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
