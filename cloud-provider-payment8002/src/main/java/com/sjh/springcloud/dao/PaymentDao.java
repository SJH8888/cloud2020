package com.sjh.springcloud.dao;

import com.sjh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author SJH
 * @create 2020/4/30
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment selectPaymentById(Long id);
}
