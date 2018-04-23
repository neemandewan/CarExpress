package com.car.express.services.impl;

import com.car.express.models.Car;
import com.car.express.repository.CarRepository;
import com.car.express.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Neeman on 18/04/2018.
 */

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public void add(Car car) throws AccessDeniedException {
        carRepository.save(car);
    }

    @Override
    public List<Car> findAll() throws AccessDeniedException {
        return carRepository.findAll();
    }

    @Override
    public Car findById(Long id) throws AccessDeniedException {
        return carRepository.getOne(id);
    }
}
