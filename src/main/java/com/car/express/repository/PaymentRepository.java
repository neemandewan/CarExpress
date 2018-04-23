package com.car.express.repository;

import com.car.express.models.Payment;
import com.car.express.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Neeman on 18/04/2018.
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("select p from  Payment p WHERE p.paidBy = :paidBy")
    List<Payment> findByPaidBy(@Param("paidBy") User paidBy);

    @Query("select p from  Payment p WHERE p.paidTo = :paidTo")
    List<Payment> findByPaidTo(@Param("paidTo") User paidTo);
}
