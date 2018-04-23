package com.car.express.services;

import com.car.express.models.Payment;
import com.car.express.models.User;

import java.util.List;

/**
 * Created by Neeman on 18/04/2018.
 */
public interface PaymentService {

    void add(Payment payment);
    List<Payment> findAll();
    Payment findById(Long id);

    List<Payment> findByPaidBy(User user);
    List<Payment> findByPaidTo(User user);
}
