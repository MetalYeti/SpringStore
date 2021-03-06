package com.geekbrains.geekmarketsummer.repositories;

import com.geekbrains.geekmarketsummer.entites.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUserName(String userName);
}
