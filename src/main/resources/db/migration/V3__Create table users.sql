CREATE TABLE `spring_shop`.`users` (
                                       `id` INT NOT NULL AUTO_INCREMENT,
                                       `username` VARCHAR(45) NOT NULL,
                                       `password` VARCHAR(100) NOT NULL,
                                       `first_name` VARCHAR(45) NOT NULL,
                                       `last_name` VARCHAR(45) NOT NULL,
                                       `email` VARCHAR(45) NOT NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                       UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);