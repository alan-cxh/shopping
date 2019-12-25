package com.example.shopping.common.exception;

import lombok.Getter;

/**
 * Created by zhoutaoo on 2018/6/2.
 */
@Getter
public class ServiceException extends RuntimeException {

    public ServiceException(){

    }

    public ServiceException(SystemType systemType){
        super(systemType.getMessage());
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
