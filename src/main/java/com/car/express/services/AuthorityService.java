package com.car.express.services;

import com.car.express.models.Authority;

/**
 * Created by Neeman on 18/04/2018.
 */
public interface AuthorityService {
    Authority findByRole(String s);
}
