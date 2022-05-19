CREATE TABLE `spring_shop`.`orders_item` (
                                             `id` INT NOT NULL AUTO_INCREMENT,
                                             `quantity` INT NOT NULL,
                                             `item_price` DOUBLE NOT NULL,
                                             `total_price` DOUBLE NOT NULL,
                                             `product_id` INT NOT NULL,
                                             `order_id` INT NOT NULL,
                                             PRIMARY KEY (`id`),
                                             UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
                                             INDEX `jk_ordersitems_product_id_idx` (`product_id` ASC) VISIBLE,
                                             INDEX `fk_ordersitems_orders_id_idx` (`order_id` ASC) VISIBLE,
                                             CONSTRAINT `fk_ordersitems_orders_id`
                                                 FOREIGN KEY (`order_id`)
                                                     REFERENCES `spring_shop`.`orders` (`id`)
                                                     ON DELETE NO ACTION
                                                     ON UPDATE NO ACTION,
                                             CONSTRAINT `jk_ordersitems_product_id`
                                                 FOREIGN KEY (`product_id`)
                                                     REFERENCES `spring_shop`.`products` (`id`)
                                                     ON DELETE NO ACTION
                                                     ON UPDATE NO ACTION);
