CREATE TABLE `spring_shop`.`orders_statuses` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `title` VARCHAR(45) NOT NULL,
                                                 PRIMARY KEY (`id`),
                                                 UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);