CREATE TABLE `spring-boot-db`.`CUST_ADDRESS` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `unit` VARCHAR(45) NULL,
  `floor` VARCHAR(45) NULL,
  `block` VARCHAR(45) NULL,
  `street` VARCHAR(45) NULL,
  `area` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `pin` INT NULL,
  `cust_id` INT NULL,
  PRIMARY KEY (`id`));
  
  
  