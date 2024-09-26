-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Areas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Areas` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Areas` (
  `idAreas` INT NOT NULL,
  `nombreArea` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAreas`))
ENGINE = InnoDB;

INSERT INTO `mydb`.`Areas` (`idAreas`, `nombreArea`) VALUES
(1, 'Psiquiatría'),
(2, 'Neurólogos'),
(3, 'Psicólogos'),
(4, 'Terapeutas');
-- -----------------------------------------------------
-- Table `mydb`.`Sedes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Sedes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Sedes` (
  `idSedes` INT NOT NULL,
  `nombreSede` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idSedes`))
ENGINE = InnoDB;

INSERT INTO `mydb`.`Sedes` (`idSedes`, `nombreSede`) VALUES
(1, 'San Martín'),
(2, 'Lima'),
(3, 'Arequipa'),
(4, 'Trujillo'),
(5, 'Ayacucho');


-- -----------------------------------------------------
-- Table `mydb`.`Profesionales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Profesionales` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Profesionales` (
  `idProfesionales` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `imagen` VARCHAR(255) NOT NULL,
  `descripcionProfesional` VARCHAR(90) NOT NULL,
  `idArea` INT NOT NULL,
  `idSede` INT NOT NULL,
  PRIMARY KEY (`idProfesionales`),
  INDEX `fk_Profesionales_Areas_idx` (`idArea` ASC) ,
  INDEX `fk_Profesionales_Sedes1_idx` (`idSede` ASC) ,
  CONSTRAINT `fk_Profesionales_Areas`
    FOREIGN KEY (`idArea`)
    REFERENCES `mydb`.`Areas` (`idAreas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Profesionales_Sedes1`
    FOREIGN KEY (`idSede`)
    REFERENCES `mydb`.`Sedes` (`idSedes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `mydb`.`Profesionales` (`idProfesionales`, `nombre`,`imagen`, `descripcionProfesional`,`idArea`, `idSede` ) VALUES
(1, 'Leonardo Campos', 'https://www.shutterstock.com/image-photo/healthcare-medical-staff-concept-portrait-600nw-2281024823.jpg', 'Psiquiatra experto en psicosis', 1, 1),
(2, 'Ronald Boyer', 'https://www.shutterstock.com/image-photo/man-portrait-doctor-white-coat-600nw-2280796707.jpg', 'Psiquiatra experto en TDAH', 1, 2),
(3, 'Karla Pezo', 'https://plus.unsplash.com/premium_photo-1658506671316-0b293df7c72b?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8ZG9jdG9yfGVufDB8fDB8fHww','Psiquiatra experto en Amnesia', 1, 3),
(4, 'Mayra Gonzales', 'https://www.shutterstock.com/image-photo/healthcare-medical-staff-concept-portrait-600nw-2281024823.jpg', 'Psiquiatra experto en psicosis', 1, 1),
(5, 'Franco Lazo', 'https://www.shutterstock.com/image-photo/man-portrait-doctor-white-coat-600nw-2280796707.jpg', 'Psiquiatra experto en TDAH', 1, 2),
(6, 'Victor Guerra', 'https://plus.unsplash.com/premium_photo-1658506671316-0b293df7c72b?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8ZG9jdG9yfGVufDB8fDB8fHww','Psiquiatra experto en Amnesia', 1, 3),
(7, 'Paolo Valiente', 'https://www.shutterstock.com/image-photo/healthcare-medical-staff-concept-portrait-600nw-2281024823.jpg', 'Psiquiatra experto en psicosis', 1, 1),
(8, 'Alonso Llanos', 'https://www.shutterstock.com/image-photo/man-portrait-doctor-white-coat-600nw-2280796707.jpg', 'Psiquiatra experto en TDAH', 1, 2),
(9, 'Diego Torres', 'https://www.shutterstock.com/image-photo/healthcare-medical-staff-concept-portrait-600nw-2281024823.jpg', 'Psiquiatra experto en psicosis', 1, 1),
(10, 'Piero Mendoza', 'https://www.shutterstock.com/image-photo/man-portrait-doctor-white-coat-600nw-2280796707.jpg', 'Psiquiatra experto en TDAH', 1, 2),
(11, 'Hellen Aranda', 'https://www.shutterstock.com/image-photo/healthcare-medical-staff-concept-portrait-600nw-2281024823.jpg', 'Psiquiatra experto en psicosis', 1, 1)
;



-- -----------------------------------------------------
-- Table `mydb`.`Fechas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Fechas` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Fechas` (
  `idFechas` INT NOT NULL,
  `fechaDisponibilidad` DATE NOT NULL,
  `idProfesional` INT NOT NULL,
  PRIMARY KEY (`idFechas`, `idProfesional`),
  INDEX `fk_Fechas_Profesionales1_idx` (`idProfesional` ASC) ,
  CONSTRAINT `fk_Fechas_Profesionales1`
    FOREIGN KEY (`idProfesional`)
    REFERENCES `mydb`.`Profesionales` (`idProfesionales`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
INSERT INTO `mydb`.`Fechas` (`idFechas`, `fechaDisponibilidad`, `idProfesional`) VALUES
(1, '2024-09-09', 1),
(2, '2024-10-06', 2),
(3, '2024-09-09', 3),
(4,'2024-09-09', 4),
(5, '2024-09-09', 5),
(6, '2024-11-09', 6),
(7, '2024-09-09', 7),
(8,'2024-12-09', 8),
(9,'2024-09-09', 9),
(10,'2024-11-10', 10),
(11,'2024-09-09',11);


-- -----------------------------------------------------
-- Table `mydb`.`Pacientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Pacientes` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Pacientes` (
  `idPacientes` INT NOT NULL AUTO_INCREMENT,
  `nombrePaciente` VARCHAR(45) NULL,
  `DNI` VARCHAR(45) NULL,
  `Edad` INT NULL,
  `Pacientescol` VARCHAR(45) NULL,
  PRIMARY KEY (`idPacientes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Riesgos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Riesgos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Riesgos` (
  `idRiesgos` INT NOT NULL,
  `Bajo` INT NOT NULL,
  `Moderado` INT NOT NULL,
  `Alto` INT NOT NULL,
  `Muy Alto` INT NOT NULL,
  PRIMARY KEY (`idRiesgos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Citas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Citas` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Citas` (
  `idCitas` INT NOT NULL AUTO_INCREMENT,
  `motivoConsulta` VARCHAR(45) NOT NULL,
  `idPaciente` INT NOT NULL,
  `idArea` INT NOT NULL,
  `idProfesional` INT NOT NULL,
  `idSede` INT NOT NULL,
  `idFechaConsulta` INT NOT NULL,
  `idRiesgo` INT NOT NULL,
  `precio` DECIMAL NULL,
  `Citascol` VARCHAR(45) NULL,
  PRIMARY KEY (`idCitas`),
  INDEX `fk_Citas_Fechas1_idx` (`idFechaConsulta` ASC, `idProfesional` ASC) ,
  INDEX `fk_Citas_Areas1_idx` (`idArea` ASC) ,
  INDEX `fk_Citas_Sedes1_idx` (`idSede` ASC) ,
  INDEX `fk_Citas_Pacientes1_idx` (`idPaciente` ASC) ,
  INDEX `fk_Citas_Riesgos1_idx` (`idRiesgo` ASC) ,
  CONSTRAINT `fk_Citas_Fechas1`
    FOREIGN KEY (`idFechaConsulta` , `idProfesional`)
    REFERENCES `mydb`.`Fechas` (`idFechas` , `idProfesional`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Citas_Areas1`
    FOREIGN KEY (`idArea`)
    REFERENCES `mydb`.`Areas` (`idAreas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Citas_Sedes1`
    FOREIGN KEY (`idSede`)
    REFERENCES `mydb`.`Sedes` (`idSedes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Citas_Pacientes1`
    FOREIGN KEY (`idPaciente`)
    REFERENCES `mydb`.`Pacientes` (`idPacientes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Citas_Riesgos1`
    FOREIGN KEY (`idRiesgo`)
    REFERENCES `mydb`.`Riesgos` (`idRiesgos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Foro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Foro` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Foro` (
  `idForo` INT NOT NULL,
  `comentario` VARCHAR(45) NOT NULL,
  `nombrePersona` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idForo`))
ENGINE = InnoDB;
INSERT INTO `mydb`.`Foro` (`idForo`, `comentario`, `nombrePersona`) VALUES
(1, 'Excelente atención', 'Carlos Pérez'),
(2, 'Muy profesional', 'María García');

-- -----------------------------------------------------
-- Table `mydb`.`Recursos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Recursos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Recursos` (
  `idRecursos` INT NOT NULL,
  PRIMARY KEY (`idRecursos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Frases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Frases` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Frases` (
  `idFrases` INT NOT NULL,
  `frase` VARCHAR(45) NULL,
  `idRecurso` INT NOT NULL,
  PRIMARY KEY (`idFrases`, `idRecurso`),
  INDEX `fk_Frases_Recursos1_idx` (`idRecurso` ASC) ,
  CONSTRAINT `fk_Frases_Recursos1`
    FOREIGN KEY (`idRecurso`)
    REFERENCES `mydb`.`Recursos` (`idRecursos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Canciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Canciones` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Canciones` (
  `idCanciones` INT NOT NULL,
  `nombreCancion` VARCHAR(45) NOT NULL,
  `tipoCancion` INT NOT NULL,
  `idRecurso` INT NOT NULL,
  PRIMARY KEY (`idCanciones`, `idRecurso`),
  INDEX `fk_Canciones_Recursos1_idx` (`idRecurso` ASC) ,
  CONSTRAINT `fk_Canciones_Recursos1`
    FOREIGN KEY (`idRecurso`)
    REFERENCES `mydb`.`Recursos` (`idRecursos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
