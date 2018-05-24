-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-05-2018 a las 06:11:07
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `patitofeo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asientospelicula`
--

CREATE TABLE `asientospelicula` (
  `clavePelicula` varchar(10) NOT NULL,
  `numeroAsiento` int(3) NOT NULL,
  `estado` int(2) NOT NULL,
  `usuario` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `asientospelicula`
--

INSERT INTO `asientospelicula` (`clavePelicula`, `numeroAsiento`, `estado`, `usuario`) VALUES
('coco2018TR', 18, 1, 'samuel'),
('coco2018TR', 35, 1, 'Carlos'),
('coco2018TR', 44, 1, 'Carlos'),
('coco2018TR', 54, 1, 'Carlos'),
('coco2018TR', 65, 1, 'Carlos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `clavePelicula` varchar(10) NOT NULL,
  `nombrePelicula` varchar(50) NOT NULL,
  `urlImagen` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`clavePelicula`, `nombrePelicula`, `urlImagen`) VALUES
('coco2018TR', 'Coco: Recuerdame Abuelita', '/Coco.png'),
('ferd2018TR', 'Ferdinand: El toro que no queria morir', '/Ferdinand.png'),
('ITIT2018TR', 'IT: Payaso Asesino', '/It.png'),
('Juma2018TR', 'Jumanji: Aventura en la selva', '/Jumanji.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario` varchar(30) NOT NULL,
  `clave` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuario`, `clave`) VALUES
('Carlos', '123456'),
('chino', 'chino1212'),
('samuel', 'bipper7u7');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asientospelicula`
--
ALTER TABLE `asientospelicula`
  ADD PRIMARY KEY (`clavePelicula`,`numeroAsiento`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`clavePelicula`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
