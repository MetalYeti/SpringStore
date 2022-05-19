package com.geekbrains.geekmarketsummer.repositories;

import com.geekbrains.geekmarketsummer.entites.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
