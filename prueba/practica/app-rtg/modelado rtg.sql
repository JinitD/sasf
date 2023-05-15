CREATE TABLE `Usuario` (
  `idusuario` integer PRIMARY KEY,
  `correo` varchar(255),
  `password` varchar(255),
  `nombre` varchar(255),
  `rol` json,
  `telefono` varchar(255)
);

CREATE TABLE `Inmueble` (
  `idinmueble` integer PRIMARY KEY,
  `direccion` varchar(255) NOT NULL,
  `estado` char,
  `precio` double,
  `tipo` varchar(255),
  `fk_idempleado` integer
);

CREATE TABLE `Peticion` (
  `idpeticion` integer PRIMARY KEY,
  `estado` char,
  `fk_idinmueble` integer,
  `fk_idcliente` integer
);

ALTER TABLE `Inmueble` ADD FOREIGN KEY (`fk_idempleado`) REFERENCES `Usuario` (`idusuario`);

ALTER TABLE `Peticion` ADD FOREIGN KEY (`fk_idcliente`) REFERENCES `Usuario` (`idusuario`);

ALTER TABLE `Peticion` ADD FOREIGN KEY (`fk_idinmueble`) REFERENCES `Inmueble` (`idinmueble`);
