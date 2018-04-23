package com.car.express.controllers;

import com.car.express.models.Car;
import com.car.express.models.Comment;
import com.car.express.models.Payment;
import com.car.express.models.User;
import com.car.express.services.CarService;
import com.car.express.services.PaymentService;
import com.car.express.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Neeman on 18/04/2018.
 */

@RestController
@RequestMapping( value = "/api/payment", produces = MediaType.APPLICATION_JSON_VALUE )
public class PaymentController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody Payment payment,
                                 @AuthenticationPrincipal User user) throws ServerException {

        Car car = carService.findById(payment.getCarId());
        payment.setCar(car);
        payment.setPaidTo(userService.findById(payment.getOldUserId()));
        payment.setPaidBy(user);

        paymentService.add(payment);

        Map<String, String> result = new HashMap<>();
        result.put( "result", "success" );
        return ResponseEntity.accepted().body(result);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Payment> get(@AuthenticationPrincipal User user) throws ServerException {

        System.out.println(user.getId());

        List<Payment> payments =  paymentService.findByPaidBy(user);

        payments.forEach(System.out::println);

        return  payments;
    }
}
