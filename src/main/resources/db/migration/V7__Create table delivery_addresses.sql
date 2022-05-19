CREATE TABLE `spring_shop`.`delivery_addresses` (
                                                    `id` INT NOT NULL AUTO_INCREMENT,
                                                    `address` VARCHAR(100) NOT NULL,
                                                    `user_id` INT NOT NULL,
                                                    PRIMARY KEY (`id`),
                                                    UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                    INDEX `fk_user_id_idx` (`user_id` ASC) VISIBLE,
                                                    CONSTRAINT `fk_address_user_id`
                                                        FOREIGN KEY (`user_id`)
                                                            REFERENCES `spring_shop`.`users` (`id`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION);