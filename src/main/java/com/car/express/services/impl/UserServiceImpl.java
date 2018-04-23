package com.car.express.services.impl;

import com.car.express.models.User;
import com.car.express.repository.UserRepository;
import com.car.express.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Neeman on 16/04/2018.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username ) throws UsernameNotFoundException {
        User u = userRepository.findByUsername( username );
        return u;
    }

    @Override
    public User findByEmail(String email) throws UsernameNotFoundException{
        User u = userRepository.findByEmail(email);
        return u;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    public User findById( Long id ) throws AccessDeniedException {
        User u = userRepository.getOne(id);
        return u;
    }

    public List<User> findAll() throws AccessDeniedException {
        List<User> result = userRepository.findAll();
        return result;
    }
}
