package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.security.KeyStore;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";     // 端口写死，单机版只会使用8001一个端口
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";  //由于是集群所以使用的是注册中心的微服务名称

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/payment/save")
    public CommonResult<Payment> save(Payment payment){

        return restTemplate.postForObject(PAYMENT_URL+"/payment/save",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

        return restTemplate.getForObject(PAYMENT_URL+"/payment/getpayment/"+id,CommonResult.class);
    }
}
