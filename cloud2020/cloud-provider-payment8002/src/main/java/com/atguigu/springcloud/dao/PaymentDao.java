package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    //添加
    public int save(Payment payment);

    //查询
    public Payment getPaymentById(@Param("id") Long id );
}


/**
 * 顺序:  pom  yml  dao  mapper(daoImpl)  service   serviceImpl  controller
 */