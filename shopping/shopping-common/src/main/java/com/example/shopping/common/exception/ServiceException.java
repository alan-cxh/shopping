package com.example.shopping.common.exception;

/**
 * Created by zhoutaoo on 2018/6/2.
 */
public class ServiceException extends RuntimeException {

    public ServiceException(){

    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
