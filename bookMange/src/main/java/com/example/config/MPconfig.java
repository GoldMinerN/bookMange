package com.example.config;


import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MPconfig {
     @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
         //定义拦截器
         MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
         //添加具体的分页拦截器
         interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
         return interceptor;
     }
}
