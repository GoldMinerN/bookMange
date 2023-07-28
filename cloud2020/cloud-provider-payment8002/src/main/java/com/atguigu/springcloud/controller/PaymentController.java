package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverport;

    @PostMapping(value = "/save")
    public CommonResult save(@RequestBody Payment payment){
        int result = paymentService.save(payment);
        log.info("*****插入成功："+ result );

        if (result > 0){
            return new CommonResult(200,"插入数据库成功,服务端口号为："+serverport,result);
        }else {
            return new CommonResult(404,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/getpayment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询成功："+payment);

        if (payment != null){
            return new CommonResult(200,"查询数据库成功，服务端口号为："+serverport,payment);
        }else {
            return new CommonResult(404,"查询数据库失败，查询id为："+id,null);
        }


    }
}
