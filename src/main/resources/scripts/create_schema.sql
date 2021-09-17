-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema exhibitions
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `exhibitions` ;

-- -----------------------------------------------------
-- Schema exhibitions
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `exhibitions` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `exhibitions` ;

-- -----------------------------------------------------
-- Table `exhibitions`.`areas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exhibitions`.`areas` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `area` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `exhibitions`.`themes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exhibitions`.`themes` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `theme` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `exhibitions`.`exhibitions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exhibitions`.`exhibitions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_theme` INT(11) NULL DEFAULT NULL,
  `start_date` DATE NULL DEFAULT NULL,
  `end_date` DATE NULL DEFAULT NULL,
  `start_time` TIME NULL DEFAULT NULL,
  `end_time` TIME NULL DEFAULT NULL,
  `entry_cost` INT(6) NULL DEFAULT NULL,
  `status` ENUM('in_progress', 'expected', 'passed') NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `exhibition_themes` (`id_theme` ASC) VISIBLE,
  CONSTRAINT `exhibition_themes`
    FOREIGN KEY (`id_theme`)
    REFERENCES `exhibitions`.`themes` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `exhibitions`.`exhibition_areas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exhibitions`.`exhibition_areas` (
  `id_area` INT(11) NOT NULL,
  `id_exhibition` INT(11) NOT NULL,
  PRIMARY KEY (`id_area`, `id_exhibition`),
  INDEX `place_of_exhibition` (`id_exhibition` ASC) VISIBLE,
  CONSTRAINT `exhibition_areas_ibfk_1`
    FOREIGN KEY (`id_area`)
    REFERENCES `exhibitions`.`areas` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `place_of_exhibition`
    FOREIGN KEY (`id_exhibition`)
    REFERENCES `exhibitions`.`exhibitions` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `exhibitions`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exhibitions`.`users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NULL DEFAULT NULL,
  `email` VARCHAR(40) NULL DEFAULT NULL,
  `password` VARCHAR(32) NULL DEFAULT NULL,
  `role` ENUM('annonimous', 'user', 'admin') NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `exhibitions`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exhibitions`.`tickets` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `id_exhibition` INT(11) NOT NULL,
  `id_user` INT(11) NOT NULL,
  `sold_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `sold_tickets`
    FOREIGN KEY (`id_exhibition`)
    REFERENCES `exhibitions`.`exhibitions` (`id`),
  CONSTRAINT `tickets_ibfk_1`
    FOREIGN KEY (`id_user`)
    REFERENCES `exhibitions`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
