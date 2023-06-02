CREATE TABLE `user` (
  `id` INT PRIMARY KEY,
  `nombre` VARCHAR,
  `fecha_registro` DATE
);

CREATE TABLE `role` (
  `id` INT PRIMARY KEY,
  `name` VARCHAR,
  `id_user` INT
);

CREATE TABLE `citas` (
  `id` INT PRIMARY KEY,
  `paciente_id` INT,
  `medico_id` INT,
  `enfermero_id` INT,
  `estado` VARCHAR(1),
  `id_area_conocimiento` VARCHAR,
  `fecha_cita` DATE,
  `observaciones` VARCHAR,
  `receta_medica` VARCHAR
);

CREATE TABLE `areaconocimineto` (
  `id` INT PRIMARY KEY,
  `nombre` VARCHAR,
  `detalle` VARCHAR
);

CREATE TABLE `facturas` (
  `id` INT PRIMARY KEY,
  `estado` VARCHAR(1),
  `paciente_id` INT,
  `fecha_factura` DATE,
  `total` DECIMAL(10, 2)
);

ALTER TABLE
  `role`
ADD
  FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

ALTER TABLE
  `citas`
ADD
  FOREIGN KEY (`paciente_id`) REFERENCES `user` (`id`);

ALTER TABLE
  `citas`
ADD
  FOREIGN KEY (`medico_id`) REFERENCES `user` (`id`);

ALTER TABLE
  `citas`
ADD
  FOREIGN KEY (`enfermero_id`) REFERENCES `user` (`id`);

ALTER TABLE
  `facturas`
ADD
  FOREIGN KEY (`paciente_id`) REFERENCES `user` (`id`);

ALTER TABLE
  `citas`
ADD
  FOREIGN KEY (`id_area_conocimiento`) REFERENCES `areaconocimineto` (`id`);