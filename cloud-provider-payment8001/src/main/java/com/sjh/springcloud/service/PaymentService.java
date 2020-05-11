package com.sjh.springcloud.service;

import com.sjh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author SJH
 * @create 2020/4/30
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment selectPaymentById(@Param("id")Long id);
}
