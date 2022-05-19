CREATE TABLE `spring_shop`.`users_roles` (
                                             `user_id` INT NOT NULL,
                                             `role_id` INT NOT NULL,
                                             INDEX `fk_user_id_idx` (`user_id` ASC) VISIBLE,
                                             INDEX `fk_role_id_idx` (`role_id` ASC) VISIBLE,
                                             CONSTRAINT `fk_user_id`
                                                 FOREIGN KEY (`user_id`)
                                                     REFERENCES `spring_shop`.`users` (`id`)
                                                     ON DELETE NO ACTION
                                                     ON UPDATE NO ACTION,
                                             CONSTRAINT `fk_role_id`
                                                 FOREIGN KEY (`role_id`)
                                                     REFERENCES `spring_shop`.`roles` (`id`)
                                                     ON DELETE NO ACTION
                                                     ON UPDATE NO ACTION);