package com.sjh.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author SJH
 * @create 2020/5/9
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Long id) {
        return "----- PaymentFallbackService fall back --- paymentInfo_OK,/(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_TimeOut(Long id) {
        return "----- PaymentFallbackService fall back --- paymentInfo_TimeOut,/(ㄒoㄒ)/~~";
    }
}
