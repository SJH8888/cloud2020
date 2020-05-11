package com.sjh.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author SJH
 * @create 2020/5/9
 */
public interface PaymentService {
    public String paymentInfo_OK(Long id);
    public String paymentInfo_TimeOut(Long id);
    public String paymentCircuitBreaker( Long id);
}
