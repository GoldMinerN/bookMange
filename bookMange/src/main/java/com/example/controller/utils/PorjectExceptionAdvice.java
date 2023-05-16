package com.example.controller.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PorjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler(Exception.class) //（）在括号中可以写上具体的异常，不同的异常做不同的处理
    public Result doException(Exception ex){
        Result result = new Result();
        result.success(false);
        result.message("服务器故障，请稍后再试");
        ex.printStackTrace();
        return result;
    }
}
