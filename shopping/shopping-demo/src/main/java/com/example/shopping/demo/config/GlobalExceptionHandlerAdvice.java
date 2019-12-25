package com.example.shopping.demo.config;

import com.example.shopping.common.advice.DefaultGlobalExceptionHandlerAdvice;
import com.example.shopping.common.entity.vo.Result;
import com.example.shopping.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: sso-server 统一异常处理
 * @author: alan chen
 * @create: 2019-12-07 14:45
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerAdvice extends DefaultGlobalExceptionHandlerAdvice {

    @ExceptionHandler(value = {ServiceException.class})
    public Result handleException(ServiceException ex) {
        log.error(" business exception:{}", ex.getMessage());
        return Result.fail(ex.getMessage());
    }
}
