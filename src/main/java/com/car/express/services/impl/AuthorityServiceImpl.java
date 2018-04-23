package com.car.express.services.impl;

import com.car.express.models.Authority;
import com.car.express.repository.AuthorityRepository;
import com.car.express.services.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Neeman on 18/04/2018.
 */

@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority findByRole(String s) {
        return authorityRepository.findByRole(s);
    }
}
