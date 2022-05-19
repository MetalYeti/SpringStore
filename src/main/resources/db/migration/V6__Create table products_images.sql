CREATE TABLE `spring_shop`.`products_images` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `path` VARCHAR(100) NOT NULL,
                                                 `product_id` INT NOT NULL,
                                                 PRIMARY KEY (`id`),
                                                 UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                                 INDEX `fk_product_id_idx` (`product_id` ASC) VISIBLE,
                                                 CONSTRAINT `fk_images_product_id`
                                                     FOREIGN KEY (`product_id`)
                                                         REFERENCES `spring_shop`.`products` (`id`)
                                                         ON DELETE NO ACTION
                                                         ON UPDATE NO ACTION);