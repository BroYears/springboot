package com.test.payment.repository;

import com.test.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Payment findByImpUid(String impUid);
    Payment findByMerchantUid(String merchantUid);
} 