CREATE TABLE `spring_shop`.`categories` (
                                            `id` INT NOT NULL AUTO_INCREMENT,
                                            `title` VARCHAR(45) NOT NULL,
                                            `description` VARCHAR(200) NOT NULL,
                                            PRIMARY KEY (`id`),
                                            UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);