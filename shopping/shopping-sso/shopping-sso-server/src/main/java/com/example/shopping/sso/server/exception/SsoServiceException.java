package com.example.shopping.sso.server.exception;


import com.example.shopping.common.exception.ErrorType;
import com.example.shopping.common.exception.SystemType;
import lombok.Data;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Data
public class SsoServiceException extends RuntimeException {
    private String errorCode;
    private String errorMessage;


    public SsoServiceException(String errorMessage){
        super(errorMessage);
    }

    public SsoServiceException(ErrorType errorType){
        this.errorCode = errorType.getCode();
        this.errorMessage = errorType.getMesg();
    }

    public SsoServiceException(SystemType systemType){
        this.errorMessage = systemType.getMessage();
    }

    public SsoServiceException(ErrorType errorType, String errorMessage){
        this.errorCode = errorType.getCode();
        this.errorMessage = errorType.getMesg() + ":" + errorMessage;
    }

    public SsoServiceException(String errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public SsoServiceException(ErrorType errorType, Throwable throwable){
        super(throwable);
        this.errorCode = errorType.getCode();
        this.errorMessage = errorType.getMesg();
    }

    public SsoServiceException(String errorMessage, Throwable throwable){
        super(throwable);
        this.errorMessage = errorMessage;
    }



    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, RecursiveToStringStyle.SHORT_PREFIX_STYLE);
    }
}
