package com.car.express.services.impl;

import com.car.express.models.Payment;
import com.car.express.models.User;
import com.car.express.repository.PaymentRepository;
import com.car.express.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Neeman on 18/04/2018.
 */

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void add(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment findById(Long id) {
        return paymentRepository.getOne(id);
    }

    @Override
    public List<Payment> findByPaidBy(User user) {
        return paymentRepository.findByPaidBy(user);
    }

    @Override
    public List<Payment> findByPaidTo(User user) {
        return paymentRepository.findByPaidTo(user);
    }
}
