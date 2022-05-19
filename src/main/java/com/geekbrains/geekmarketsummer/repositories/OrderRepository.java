package com.geekbrains.geekmarketsummer.repositories;

import com.geekbrains.geekmarketsummer.entites.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
