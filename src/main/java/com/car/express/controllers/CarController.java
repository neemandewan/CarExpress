package com.car.express.controllers;

import com.car.express.models.Car;
import com.car.express.models.User;
import com.car.express.services.CarService;
import com.car.express.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Neeman on 18/04/2018.
 */

@RestController
@RequestMapping( value = "/api/car", produces = MediaType.APPLICATION_JSON_VALUE )
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addCar(@RequestBody Car car, @AuthenticationPrincipal User user) {
        car.setUser(user);
        carService.add(car);
        Map<String, String> result = new HashMap<>();
        result.put( "result", "success" );
        return ResponseEntity.accepted().body(result);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars() {
        List<Car> cars = carService.findAll();
        cars.forEach(System.out::println);
        //return ResponseEntity.ok(cars);
        return cars;
    }
}
