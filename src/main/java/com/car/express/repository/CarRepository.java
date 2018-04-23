package com.car.express.repository;

import com.car.express.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Neeman on 18/04/2018.
 */
public interface CarRepository extends JpaRepository<Car, Long> {
}
