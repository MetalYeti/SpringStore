package com.geekbrains.geekmarketsummer.repositories;

import com.geekbrains.geekmarketsummer.entites.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findOneByName(String theRoleName);
}
