package com.geekbrains.geekmarketsummer.services;

import com.geekbrains.geekmarketsummer.entites.SystemUser;
import com.geekbrains.geekmarketsummer.entites.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String username);
    boolean save(SystemUser systemUser);
}
