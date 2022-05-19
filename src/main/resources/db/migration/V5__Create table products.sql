CREATE TABLE `spring_shop`.`products` (
                                          `id` INT NOT NULL AUTO_INCREMENT,
                                          `category_id` INT NOT NULL,
                                          `vendor_code` INT NOT NULL,
                                          `title` VARCHAR(250) NOT NULL,
                                          `short_description` VARCHAR(50) NULL,
                                          `full_description` VARCHAR(4000) NULL,
                                          `price` DECIMAL(12,2) NOT NULL,
                                          `create_at` DATETIME NOT NULL,
                                          `update_at` DATETIME NOT NULL,
                                          PRIMARY KEY (`id`),
                                          UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                          INDEX `fk_category_id_idx` (`category_id` ASC) VISIBLE,
                                          CONSTRAINT `fk_products_category_id`
                                              FOREIGN KEY (`category_id`)
                                                  REFERENCES `spring_shop`.`categories` (`id`)
                                                  ON DELETE NO ACTION
                                                  ON UPDATE NO ACTION);