package com.geekbrains.geekmarketsummer.repositories;

import com.geekbrains.geekmarketsummer.entites.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusRepository extends CrudRepository<OrderStatus, Long> {
}
