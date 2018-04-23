package com.car.express.services;

import com.car.express.models.User;

import java.util.List;

/**
 * Created by Neeman on 16/04/2018.
 */
public interface UserService {
    User findById(Long id);
    User findByUsername(String username);
    User findByEmail(String email);
    void add(User user);
    List<User> findAll ();
}
