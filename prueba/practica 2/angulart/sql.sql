CREATE TABLE `User` (
  `id` INT PRIMARY KEY,
  `username` VARCHAR(100),
  `password` VARCHAR(100),
  `id_details` int
);

CREATE TABLE `Details` (
  `id` INT PRIMARY KEY,
  `nombre` VARCHAR(100),
  `area` VARCHAR(50),
  `informacion_adicional` VARCHAR(200),
  `rol` VARCHAR(50)
);

CREATE TABLE `Pabellones` (
  `id` INT PRIMARY KEY,
  `nombre` VARCHAR(100),
  `capacidad` INT,
  `id_personal_vigilancia` int
);

CREATE TABLE `Celdas` (
  `id` INT PRIMARY KEY,
  `id_pabellon` INT,
  `capacidad` INT,
  `id_guardia` int
);

CREATE TABLE `Reclusos` (
  `id` INT PRIMARY KEY,
  `nombre` VARCHAR(100),
  `delitos` VARCHAR(200),
  `sentencia` VARCHAR(100),
  `informacion_adicional` VARCHAR(200),
  `id_celda` INT
);

CREATE TABLE `FichasIngreso` (
  `id` INT PRIMARY KEY,
  `id_recluso` INT,
  `es_valida` BOOLEAN
);

ALTER TABLE `Pabellones` ADD FOREIGN KEY (`id_personal_vigilancia`) REFERENCES `User` (`id`);

ALTER TABLE `Celdas` ADD FOREIGN KEY (`id_guardia`) REFERENCES `User` (`id`);

ALTER TABLE `User` ADD FOREIGN KEY (`id_details`) REFERENCES `Details` (`id`);

ALTER TABLE `FichasIngreso` ADD FOREIGN KEY (`id_recluso`) REFERENCES `Reclusos` (`id`);

ALTER TABLE `Reclusos` ADD FOREIGN KEY (`id_celda`) REFERENCES `Celdas` (`id`);
