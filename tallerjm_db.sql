-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-12-2024 a las 04:53:24
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tallerjm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IDcliente` int(11) NOT NULL,
  `tipo_cliente` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cotizacion`
--

CREATE TABLE `cotizacion` (
  `IDcotizacion` int(11) NOT NULL,
  `cotizacion_nro` int(11) NOT NULL,
  `fecha_cotizacion` datetime NOT NULL,
  `id_vehiculo` int(11) NOT NULL,
  `fecha_vencimiento` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cotizacion`
--

INSERT INTO `cotizacion` (`IDcotizacion`, `cotizacion_nro`, `fecha_cotizacion`, `id_vehiculo`, `fecha_vencimiento`) VALUES
(1, 1, '2024-12-05 16:36:31', 1, '2024-12-10 14:03:23'),
(2, 2, '2024-12-05 00:00:00', 3, '2024-12-13 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_cotizacion`
--

CREATE TABLE `detalle_cotizacion` (
  `IDdetalle_cotizacion` int(11) NOT NULL,
  `fk_Id_cotizacion` int(11) NOT NULL,
  `fk_Id_valor_servicio_pieza` int(11) NOT NULL,
  `porcentaje_daño` double(6,2) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `sub_total` double NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IDempleado` int(11) NOT NULL,
  `cargo` varchar(45) NOT NULL,
  `salario` double NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IDempleado`, `cargo`, `salario`, `usuario`, `password`) VALUES
(12, 'Administrador', 1600000, 'juanc', 'juanc1234'),
(13, 'Recepcionista', 1600000, 'jandres', 'jandres123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea_vehiculo`
--

CREATE TABLE `linea_vehiculo` (
  `IDlinea_vehiculo` int(11) NOT NULL,
  `IDmarca` int(11) NOT NULL,
  `desc_linea` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `linea_vehiculo`
--

INSERT INTO `linea_vehiculo` (`IDlinea_vehiculo`, `IDmarca`, `desc_linea`) VALUES
(1, 1, 'Spark'),
(2, 1, 'Ionix-turbo'),
(3, 1, 'Traker'),
(4, 1, 'Optra'),
(5, 1, 'Luv'),
(6, 1, 'Corsa'),
(7, 1, 'Captiva XL'),
(8, 2, 'Fiesta'),
(9, 2, 'Ranger'),
(10, 2, 'Eco Sport'),
(11, 2, 'Escape'),
(12, 3, 'Captur'),
(13, 3, 'Clio'),
(14, 3, 'Duster'),
(15, 3, 'Kangoo'),
(16, 3, 'Koleos'),
(17, 3, 'Kwid'),
(18, 3, 'Laguna'),
(19, 3, 'Mégane'),
(20, 3, 'Sandero'),
(21, 3, 'Scénic'),
(22, 3, 'Symbol'),
(23, 3, 'Twingo'),
(24, 3, 'Twizy'),
(25, 4, 'Río'),
(26, 4, 'Sportage'),
(27, 5, 'Mazda 121'),
(28, 5, 'Mazda 323'),
(29, 5, 'Mazda 626'),
(30, 5, 'Mazda Allegro'),
(31, 5, 'Mazda 2'),
(32, 5, 'Mazda 3'),
(33, 5, 'Mazda CX-30'),
(34, 5, 'Mazda CX-50');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `IDmarca` int(11) NOT NULL,
  `descripcion` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`IDmarca`, `descripcion`) VALUES
(1, 'Chevrolet'),
(2, 'Ford'),
(3, 'Renault'),
(4, 'Kia'),
(5, 'Mazda'),
(6, 'Jeep'),
(7, 'Fiat'),
(8, 'Honda'),
(9, 'Hyundai'),
(10, 'Mitsubishi'),
(11, 'Nissan'),
(12, 'Peugeot'),
(13, 'Seat'),
(14, 'Toyota');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_trabajo`
--

CREATE TABLE `orden_trabajo` (
  `IDorden` int(11) NOT NULL,
  `id_cotizacion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_trabajo_empleado`
--

CREATE TABLE `orden_trabajo_empleado` (
  `IDorden_trabajo_empleado` int(11) NOT NULL,
  `id_orden_trabajo` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `IDpersona` int(11) NOT NULL,
  `tipo_documento` varchar(45) NOT NULL,
  `numero_documento` varchar(45) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contacto` varchar(15) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `estado` int(11) NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`IDpersona`, `tipo_documento`, `numero_documento`, `nombres`, `apellidos`, `email`, `contacto`, `direccion`, `estado`, `fecha_registro`) VALUES
(7, 'Cédula ciudadanía', '43848385', 'Diana María', 'Celis Ospina', 'diana.celis@hotmail.com', '316679010', 'Carrera 80 # 49 - 50', 1, '2024-10-31 16:15:14'),
(9, 'Cédula ciudadanía', '98530328', 'Carlos Rene', 'García Correa', 'rene@hotmail.com', '300246974', 'Calle 48 # 107 - 45', 1, '2024-10-31 16:20:11'),
(10, 'Cédula ciudadanía', '1021930524', 'Danna Sofia', 'Sánchez Celis', 'danna@hotmail.com', '3002587469', 'Calle 123 # 45 - 26', 1, '2024-10-31 16:25:02'),
(11, 'Cédula ciudadanía', '70810536', 'Luis Carlos', 'Ríos Perez', 'luis@hotmail.com', '3057106369', 'Calle 98 # 70 - 106', 1, '2024-10-31 16:49:07'),
(12, 'Seleccione un opción', '70510189', 'Juan Carlos', 'Posada López', 'juanc@gmail.com', '30045987845', 'Carrera 65 # 25 - 16', 1, '2024-11-01 17:40:59'),
(13, 'Cédula ciudadanía', '1021930524', 'Julian Andrés', 'Otalvaro Gutierrez', 'juano@hotmail.com', '3176679010', 'Carrera 81 # 49 - 54', 1, '2024-11-01 20:36:07'),
(14, 'Seleccione un opción', '48530562', 'Carlos Mauricio', 'Sánchez Zapata', 'mauro@gmail.com', '3165667696', 'Calle 107 # 87 - 241', 1, '2024-11-01 20:47:01'),
(15, 'Seleccione un opción', '70120356', 'Carlos Mauricio', 'Sánchez Zapata', 'cmauricio@gmail.com', '3152473656', 'Calle 107 # 87 - 241', 1, '2024-11-01 20:51:53'),
(16, 'Seleccione una opción', '32507701', 'Miguel Angel', 'Zapata Alavarez', 'migue@hotmail.com', '3016328574', 'Vereda el Tonusco', 1, '2024-11-01 21:10:25'),
(17, 'Cédula ciudadanía', '98617630', 'Hector Dario', 'Calle Molina', 'hector@hotmail.com', '3006175487', 'Calle 34 # 80 - 36', 1, '2024-11-04 17:25:02'),
(18, 'Cédula ciudadanía', '10121910256', 'Pablo Andrés', 'Molina Vazquez', 'pablo@hotmail.com', '3125874769', 'Calle 107 # 43 - 16', 1, '2024-11-04 17:46:59'),
(19, 'Cédula ciudadanía', '65465465', 'fsdfsdfs', 'adfdsfsdfdfadsfsdadfdsf', 'dfdsfasd', '242542424', 'fasdfdsfsdaf', 1, '2024-11-04 18:02:22'),
(20, 'Cédula ciudadanía', 'Chevrolett', 'NPR', '2012', 'Blanco', '3526947448', 'Calle 107', 1, '2024-11-04 21:36:07'),
(21, 'Cédula ciudadanía', '98258147', 'Juan Carlos', 'Areiza Zapata', 'juanc@hotmail.com', '3001592648', 'calle 84', 1, '2024-11-04 21:54:16'),
(22, 'Cédula ciudadanía', '1025478693', 'Luis Carlos', 'Arcila Díaz', 'luisca@hotmail.com', '3002694785', 'Calle 25', 1, '2024-11-04 23:45:58'),
(23, 'Cédula ciudadanía', '1025478693', 'Luis Carlos', 'Arcila Díaz', 'luisca@hotmail.com', '3002694785', 'Calle 25', 1, '2024-11-04 23:47:31'),
(24, 'Cédula ciudadanía', '71758469', 'Gustavo Adolfo', 'Ríos Palacio', 'tavo@gmail.com', '3006352987', 'carrera 65 # 98 - 75', 1, '2024-11-04 23:51:10'),
(25, 'Cédula ciudadanía', '36508253', 'Jorge Eliecer', 'Rodriguez Zapata', 'maecha@hotmail.com', '3121023648', 'Carrera 36 # 123 - 15', 1, '2024-11-05 00:14:44'),
(26, '', '', '', '', '', '', '', 1, '2024-12-06 00:58:51'),
(27, '', '', '', '', '', '', '', 1, '2024-12-06 01:01:15'),
(28, 'Cédula ciudadanía', '10636987', 'Paulina Alejandra', 'Muñoz Marín', 'paulina@hotmail.com', '300 3665798', 'Calle 36 # 98 - 77', 1, '2024-12-06 17:35:52'),
(29, 'Cédula ciudadanía', '43874526', 'Gloria María', 'Delgado Montes', 'gloria184@gmail.com', '3114112678', 'Carrera 65 # 107 - 83', 1, '2024-12-06 17:47:49');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pieza_vehiculo`
--

CREATE TABLE `pieza_vehiculo` (
  `IDpieza_vehiculo` int(11) NOT NULL,
  `IDvehiculo` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `pieza_vehiculo`
--

INSERT INTO `pieza_vehiculo` (`IDpieza_vehiculo`, `IDvehiculo`, `descripcion`) VALUES
(1, 2, 'Capó'),
(2, 2, 'Guarda fangos delantero izquierdo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietario`
--

CREATE TABLE `propietario` (
  `IDpropietario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `propietario`
--

INSERT INTO `propietario` (`IDpropietario`) VALUES
(15),
(16),
(17),
(18),
(21),
(25),
(26),
(27),
(28),
(29);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `IDservicio` int(11) NOT NULL,
  `descripcion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`IDservicio`, `descripcion`) VALUES
(1, 'Cambiar'),
(2, 'Enderezar'),
(3, 'Pintar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_vehiculo`
--

CREATE TABLE `tipo_vehiculo` (
  `IDtipo_vehiculo` int(11) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `linea` varchar(25) NOT NULL,
  `modelo` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `tipo_vehiculo`
--

INSERT INTO `tipo_vehiculo` (`IDtipo_vehiculo`, `marca`, `linea`, `modelo`) VALUES
(2, 'Chevrolet', 'Spark', '2018');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valor_servicio_pieza`
--

CREATE TABLE `valor_servicio_pieza` (
  `IDvalor` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `linea_vehiculo` varchar(45) NOT NULL,
  `modelo` varchar(4) NOT NULL,
  `pieza` varchar(100) NOT NULL,
  `servicio` varchar(50) NOT NULL,
  `valor` double NOT NULL,
  `fecha_registro` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `valor_servicio_pieza`
--

INSERT INTO `valor_servicio_pieza` (`IDvalor`, `marca`, `linea_vehiculo`, `modelo`, `pieza`, `servicio`, `valor`, `fecha_registro`) VALUES
(1, 'Chevrolet', 'Spark', '2018', 'Capó', 'Cambiar', 40000, '2024-12-02 21:25:18'),
(2, 'Chevrolet', 'Ionix-turbo', '2020', 'Tapa Maleta', 'Cambiar', 60000, '2024-12-02 21:27:02'),
(3, 'Ford', 'Eco Sport', '2017', 'Guarda barros delantero Derecho', 'Enderezar', 45000, '2024-12-02 21:52:00'),
(4, 'Chevrolet', 'Optra', '2012', 'Puerta trasera Izquierda', 'Enderezar', 45000, '2024-12-02 21:57:06'),
(5, 'Chevrolet', 'Traker', '2020', 'Nave trasera Derecha', 'Pintar', 65000, '2024-12-02 21:23:47'),
(6, 'Mazda', 'Mazda CX-30', '2023', 'Capó', 'Pintar', 360000, '2024-12-02 21:51:21'),
(7, 'Ford', 'Ranger', '1995', 'Bomper delantero', 'Cambiar', 20000, '2024-12-05 14:11:00'),
(8, 'Mazda', 'Mazda 2', '2021', 'Puerta delantera Derecha', 'Pintar', 210000, '2024-12-06 17:42:37');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `IDvehiculo` int(11) NOT NULL,
  `idpropietario` int(11) NOT NULL,
  `placa` varchar(6) NOT NULL,
  `fk_marca` int(11) NOT NULL,
  `fk_linea` int(11) NOT NULL,
  `modelo` varchar(4) NOT NULL,
  `color` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`IDvehiculo`, `idpropietario`, `placa`, `fk_marca`, `fk_linea`, `modelo`, `color`) VALUES
(1, 21, 'WCP193', 2, 10, '2019', 'Gris'),
(2, 21, 'NGL259', 1, 3, '2021', 'Azúl'),
(3, 25, 'GPO265', 4, 25, '2018', 'Blanco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `web_usuario`
--

CREATE TABLE `web_usuario` (
  `IDweb_usuario` int(11) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  `comentario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IDcliente`);

--
-- Indices de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD PRIMARY KEY (`IDcotizacion`),
  ADD UNIQUE KEY `cotizacion_nro` (`cotizacion_nro`),
  ADD KEY `fk_vehiculo_cotizacion_idx` (`id_vehiculo`);

--
-- Indices de la tabla `detalle_cotizacion`
--
ALTER TABLE `detalle_cotizacion`
  ADD PRIMARY KEY (`IDdetalle_cotizacion`),
  ADD KEY `fk_Id_cotizacion` (`fk_Id_cotizacion`),
  ADD KEY `fk_id_valor_servicio_pieza` (`fk_Id_valor_servicio_pieza`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IDempleado`),
  ADD UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  ADD KEY `IDpersona` (`IDempleado`);

--
-- Indices de la tabla `linea_vehiculo`
--
ALTER TABLE `linea_vehiculo`
  ADD PRIMARY KEY (`IDlinea_vehiculo`),
  ADD KEY `fk_marcaVehiculo_marca` (`IDmarca`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`IDmarca`);

--
-- Indices de la tabla `orden_trabajo`
--
ALTER TABLE `orden_trabajo`
  ADD PRIMARY KEY (`IDorden`),
  ADD KEY `fk_cotizacion_ordentrabajo_idx` (`id_cotizacion`);

--
-- Indices de la tabla `orden_trabajo_empleado`
--
ALTER TABLE `orden_trabajo_empleado`
  ADD PRIMARY KEY (`IDorden_trabajo_empleado`),
  ADD KEY `fk_orden_trabajo_empleado_idx` (`id_empleado`),
  ADD KEY `fk_orden_trabajo_empleado_ordentrabajo_idx` (`id_orden_trabajo`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`IDpersona`);

--
-- Indices de la tabla `pieza_vehiculo`
--
ALTER TABLE `pieza_vehiculo`
  ADD PRIMARY KEY (`IDpieza_vehiculo`),
  ADD KEY `IDvehiculo` (`IDvehiculo`);

--
-- Indices de la tabla `propietario`
--
ALTER TABLE `propietario`
  ADD PRIMARY KEY (`IDpropietario`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`IDservicio`);

--
-- Indices de la tabla `tipo_vehiculo`
--
ALTER TABLE `tipo_vehiculo`
  ADD PRIMARY KEY (`IDtipo_vehiculo`);

--
-- Indices de la tabla `valor_servicio_pieza`
--
ALTER TABLE `valor_servicio_pieza`
  ADD PRIMARY KEY (`IDvalor`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`IDvehiculo`),
  ADD KEY `idpropietario` (`idpropietario`),
  ADD KEY `fk_marca_vehiculo` (`fk_marca`),
  ADD KEY `fk_linea` (`fk_linea`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  MODIFY `IDcotizacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detalle_cotizacion`
--
ALTER TABLE `detalle_cotizacion`
  MODIFY `IDdetalle_cotizacion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `linea_vehiculo`
--
ALTER TABLE `linea_vehiculo`
  MODIFY `IDlinea_vehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `IDmarca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `orden_trabajo`
--
ALTER TABLE `orden_trabajo`
  MODIFY `IDorden` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `orden_trabajo_empleado`
--
ALTER TABLE `orden_trabajo_empleado`
  MODIFY `IDorden_trabajo_empleado` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `IDpersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `pieza_vehiculo`
--
ALTER TABLE `pieza_vehiculo`
  MODIFY `IDpieza_vehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `IDservicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tipo_vehiculo`
--
ALTER TABLE `tipo_vehiculo`
  MODIFY `IDtipo_vehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `valor_servicio_pieza`
--
ALTER TABLE `valor_servicio_pieza`
  MODIFY `IDvalor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `IDvehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_persona_cliente` FOREIGN KEY (`IDcliente`) REFERENCES `persona` (`IDpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `cotizacion`
--
ALTER TABLE `cotizacion`
  ADD CONSTRAINT `fk_vehiculo_cotizacion` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculo` (`IDvehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_cotizacion`
--
ALTER TABLE `detalle_cotizacion`
  ADD CONSTRAINT `fk_Id_cotizacion` FOREIGN KEY (`fk_Id_cotizacion`) REFERENCES `cotizacion` (`IDcotizacion`),
  ADD CONSTRAINT `fk_id_valor_servicio_pieza` FOREIGN KEY (`fk_Id_valor_servicio_pieza`) REFERENCES `valor_servicio_pieza` (`IDvalor`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_persona_trabajador` FOREIGN KEY (`IDempleado`) REFERENCES `persona` (`IDpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `linea_vehiculo`
--
ALTER TABLE `linea_vehiculo`
  ADD CONSTRAINT `fk_marcaVehiculo_marca` FOREIGN KEY (`IDmarca`) REFERENCES `marca` (`IDmarca`);

--
-- Filtros para la tabla `orden_trabajo`
--
ALTER TABLE `orden_trabajo`
  ADD CONSTRAINT `fk_ordentrabajo_cotizacion` FOREIGN KEY (`id_cotizacion`) REFERENCES `cotizacion` (`IDcotizacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `orden_trabajo_empleado`
--
ALTER TABLE `orden_trabajo_empleado`
  ADD CONSTRAINT `fk_orden_trabajo_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`IDempleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_orden_trabajo_empleado_ordentrabajo` FOREIGN KEY (`id_orden_trabajo`) REFERENCES `orden_trabajo` (`IDorden`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pieza_vehiculo`
--
ALTER TABLE `pieza_vehiculo`
  ADD CONSTRAINT `fk_pieza_vehiculo` FOREIGN KEY (`IDvehiculo`) REFERENCES `tipo_vehiculo` (`IDtipo_vehiculo`);

--
-- Filtros para la tabla `propietario`
--
ALTER TABLE `propietario`
  ADD CONSTRAINT `fk_persona_propietario` FOREIGN KEY (`IDpropietario`) REFERENCES `persona` (`IDpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `fk_linea` FOREIGN KEY (`fk_linea`) REFERENCES `linea_vehiculo` (`IDlinea_vehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_marca_vehiculo` FOREIGN KEY (`fk_marca`) REFERENCES `marca` (`IDmarca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `vehiculo_ibfk_1` FOREIGN KEY (`idpropietario`) REFERENCES `propietario` (`IDpropietario`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
