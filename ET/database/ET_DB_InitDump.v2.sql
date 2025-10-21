-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ET_DB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ET_DB` ;

-- -----------------------------------------------------
-- Schema ET_DB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ET_DB` DEFAULT CHARACTER SET utf8mb4 ;
USE `ET_DB` ;

-- -----------------------------------------------------
-- Table `ET_DB`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ET_DB`.`category` ;

CREATE TABLE IF NOT EXISTS `ET_DB`.`category` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `name_srch` VARCHAR(45) GENERATED ALWAYS AS (UPPER(name)) VIRTUAL COMMENT 'This helps in efficient searching of category name and ensures uniqueness.',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `category_id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `name_srch_UNIQUE` (`name_srch` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `ET_DB`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ET_DB`.`user` ;

CREATE TABLE IF NOT EXISTS `ET_DB`.`user` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(16) NOT NULL,
  `password` VARCHAR(32) NOT NULL,
  `create_dttm` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


-- -----------------------------------------------------
-- Table `ET_DB`.`expenses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ET_DB`.`expenses` ;

CREATE TABLE IF NOT EXISTS `ET_DB`.`expenses` (
  `user_id` BIGINT UNSIGNED NOT NULL,
  `category_id` INT UNSIGNED NOT NULL,
  `create_dttm` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'This determines the date and time this expense record is created.',
  `description` VARCHAR(255) NOT NULL COMMENT 'This gives detailed description of the said expense under a specific category.',
  `amount` DECIMAL(14,2) NOT NULL COMMENT 'This determines the amount of the expense.\n\nRange of values is up to billions.',
  `expense_date` DATE NOT NULL COMMENT 'This determines the date when the expense was done.',
  PRIMARY KEY (`user_id`, `category_id`, `create_dttm`),
  INDEX `fk_expenses_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_expenses_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ET_DB`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_expenses_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `ET_DB`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS client;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'client' IDENTIFIED BY 'qwerty';

GRANT SELECT ON TABLE `ET_DB`.* TO 'client';
GRANT SELECT ON TABLE `ET_DB`.`user` TO 'client';
GRANT SELECT ON TABLE `ET_DB`.`category` TO 'client';
GRANT SELECT ON TABLE `ET_DB`.`expenses` TO 'client';
GRANT SELECT, INSERT, TRIGGER ON TABLE `ET_DB`.* TO 'client';
GRANT INSERT ON TABLE `ET_DB`.`user` TO 'client';
GRANT INSERT ON TABLE `ET_DB`.`category` TO 'client';
GRANT INSERT ON TABLE `ET_DB`.`expenses` TO 'client';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `ET_DB`.* TO 'client';
GRANT UPDATE, DELETE ON TABLE `ET_DB`.`user` TO 'client';
GRANT DELETE, UPDATE ON TABLE `ET_DB`.`category` TO 'client';
GRANT UPDATE, DELETE ON TABLE `ET_DB`.`expenses` TO 'client';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `ET_DB`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `ET_DB`;
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Foods');
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Drinks');
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Utilities');
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Housing');
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Healthcare');
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Taxes');
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Insurance');
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Fees');
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Contributions');
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Subscriptions');
INSERT INTO `ET_DB`.`category` (`id`, `name`) VALUES (DEFAULT, 'Miscellaneous');

COMMIT;


-- -----------------------------------------------------
-- Data for table `ET_DB`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `ET_DB`;
INSERT INTO `ET_DB`.`user` (`id`, `username`, `password`, `create_dttm`) VALUES (DEFAULT, 'system', 'admin', DEFAULT);

COMMIT;

