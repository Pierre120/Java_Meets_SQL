-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SST_DB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SST_DB` ;

-- -----------------------------------------------------
-- Schema SST_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SST_DB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `SST_DB` ;

-- -----------------------------------------------------
-- Table `SST_DB`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SST_DB`.`user` ;

CREATE TABLE IF NOT EXISTS `SST_DB`.`user` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `SST_DB`.`savings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SST_DB`.`savings` ;

CREATE TABLE IF NOT EXISTS `SST_DB`.`savings` (
  `user_id` BIGINT UNSIGNED NOT NULL,
  `create_dttm` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `amount` DECIMAL(14,2) NOT NULL COMMENT 'This determines the amount saved.\n\nRange of values is up to billions.',
  `save_date` DATE NOT NULL COMMENT 'This determines the date when the money was saved.',
  PRIMARY KEY (`user_id`, `create_dttm`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
  UNIQUE INDEX `create_dttm_UNIQUE` (`create_dttm` ASC) VISIBLE,
  CONSTRAINT `fk_savings_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `SST_DB`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS demo_user;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'demo_user' IDENTIFIED BY '1234';

GRANT SELECT ON TABLE `SST_DB`.* TO 'demo_user';
GRANT SELECT ON TABLE `SST_DB`.`user` TO 'demo_user';
GRANT SELECT ON TABLE `SST_DB`.`savings` TO 'demo_user';
GRANT SELECT, INSERT, TRIGGER ON TABLE `SST_DB`.* TO 'demo_user';
GRANT INSERT ON TABLE `SST_DB`.`user` TO 'demo_user';
GRANT INSERT ON TABLE `SST_DB`.`savings` TO 'demo_user';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `SST_DB`.* TO 'demo_user';
GRANT UPDATE, DELETE ON TABLE `SST_DB`.`user` TO 'demo_user';
GRANT UPDATE, DELETE ON TABLE `SST_DB`.`savings` TO 'demo_user';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `SST_DB`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `SST_DB`;
INSERT INTO `SST_DB`.`user` (`id`, `username`, `password`) VALUES (DEFAULT, 'system', 'admin');

COMMIT;

