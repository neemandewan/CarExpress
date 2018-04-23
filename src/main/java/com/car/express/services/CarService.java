package com.car.express.services;

import com.car.express.models.Car;

import java.util.List;

/**
 * Created by Neeman on 18/04/2018.
 */
public interface CarService {

    void add(Car car);
    List<Car> findAll();
    Car findById(Long id);
}
