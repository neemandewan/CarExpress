package com.car.express.repository;

import com.car.express.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Neeman on 16/04/2018.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername( String username );
    User findByEmail(String email);

}
