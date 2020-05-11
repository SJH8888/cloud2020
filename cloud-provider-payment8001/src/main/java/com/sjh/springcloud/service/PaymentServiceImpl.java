package com.sjh.springcloud.service;

import com.sjh.springcloud.dao.PaymentDao;
import com.sjh.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author SJH
 * @create 2020/4/30
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    @Override
    public Payment selectPaymentById(@Param("id")Long id){
        return paymentDao.selectPaymentById(id);
    }
}
