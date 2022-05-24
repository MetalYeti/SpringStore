CREATE TABLE `spring_shop`.`orders` (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `user_id` INT NOT NULL,
                                        `status_id` INT NOT NULL,
                                        `price` DECIMAL(12,2) NOT NULL,
                                        `delivery_price` DECIMAL(12,2) NOT NULL,
                                        `delivery_address_id` INT NOT NULL,
                                        `phone_number` VARCHAR(45) NOT NULL,
                                        `delivery_date` DATETIME NOT NULL,
                                        `create_at` DATETIME NOT NULL,
                                        PRIMARY KEY (`id`),
                                        UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                        INDEX `fk_user_id_idx` (`user_id` ASC) VISIBLE,
                                        INDEX `fk_address_id_idx` (`delivery_address_id` ASC) VISIBLE,
                                        INDEX `fk_status_id_idx` (`status_id` ASC) VISIBLE,
                                        CONSTRAINT `fk_orders_user_id`
                                            FOREIGN KEY (`user_id`)
                                                REFERENCES `spring_shop`.`users` (`id`)
                                                ON DELETE NO ACTION
                                                ON UPDATE NO ACTION,
                                        CONSTRAINT `fk_orders_address_id`
                                            FOREIGN KEY (`delivery_address_id`)
                                                REFERENCES `spring_shop`.`delivery_addresses` (`id`)
                                                ON DELETE NO ACTION
                                                ON UPDATE NO ACTION,
                                        CONSTRAINT `fk_orders_status_id`
                                            FOREIGN KEY (`status_id`)
                                                REFERENCES `spring_shop`.`orders_statuses` (`id`)
                                                ON DELETE NO ACTION
                                                ON UPDATE NO ACTION);