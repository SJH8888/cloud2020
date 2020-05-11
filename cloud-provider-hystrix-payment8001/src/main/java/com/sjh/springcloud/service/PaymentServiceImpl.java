package com.sjh.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author SJH
 * @create 2020/5/9
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    /**
     * 访问正确
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Long id){

        return "线程池："+Thread.currentThread().getName()+" paymentInfo_OK,id:"+id+"\t"+"哈哈哈哈哈";
    }

    /**
     * 访问需休息3秒,如果设置峰值时间，请求最多等待5秒，则会使用兜底方法
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")})
    public String paymentInfo_TimeOut(Long id){
        try{
            TimeUnit.MILLISECONDS.sleep(3000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfo_TimeOut,id:"+id+"\t"+"(*^_^*)";
    }



    /**
     * 兜底方法，访问超时使用
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Long id){
        return "系统繁忙或程序运行错误，请稍后再试！"+"\t"+"/(ㄒoㄒ)/~~";
    }


    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    @Override
    public String paymentCircuitBreaker(Long id) {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Long id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
