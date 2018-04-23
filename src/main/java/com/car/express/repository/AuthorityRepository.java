package com.car.express.repository;

import com.car.express.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Neeman on 18/04/2018.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    @Query("select a from  Authority a WHERE a.name = :role")
    Authority findByRole(@Param("role") String role);
}
