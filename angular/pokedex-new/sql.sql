CREATE TABLE `category` (
  `idcategory` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  PRIMARY KEY (`idcategory`)
) 

CREATE TABLE `pokemon` (
  `idpokemon` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `status` char(1) COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `idcategory` bigint DEFAULT NULL,
  PRIMARY KEY (`idpokemon`),
  CONSTRAINT FOREIGN KEY (`idcategory`) REFERENCES `category` (`idcategory`)
)

