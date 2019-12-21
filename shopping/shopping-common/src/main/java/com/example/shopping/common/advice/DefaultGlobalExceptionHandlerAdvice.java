package com.example.shopping.common.advice;

import com.example.shopping.common.entity.vo.Result;
import com.example.shopping.common.enumeration.RunCodeEnum;
import com.example.shopping.common.exception.BaseException;
import com.example.shopping.common.exception.SystemErrorType;
import com.example.shopping.common.util.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

/**
 * @description: 统一异常处理
 * @author: alan chen
 * @create: 2019-12-07 14:45
 */
@Slf4j
public class DefaultGlobalExceptionHandlerAdvice {

    /*普通异常*/
    @ExceptionHandler(value = Exception.class)
    public Object handle(Exception e) {
        log.error("系统异常：", e);
        return HttpResult.error(RunCodeEnum.SYS_RUNTION_EXCEPTION, e.getMessage());
    }

    /**
     *  请求参数异常
     */
    @ConditionalOnProperty(prefix = "globalExceptionHandler", name = "enable", havingValue = "true")
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Object handle(MethodArgumentNotValidException e) {
        log.error("请求参数有误，异常信息 ： {}", e);
        return HttpResult.error(RunCodeEnum.SYS_PARAMETER_ERROR, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = {MissingServletRequestParameterException.class})
    public Result missingServletRequestParameterException(MissingServletRequestParameterException ex) {
        log.error("missing servlet request parameter exception:{}", ex.getMessage());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID);
    }

    @ExceptionHandler(value = {MultipartException.class})
    public Result uploadFileLimitException(MultipartException ex) {
        log.error("upload file size limit:{}", ex.getMessage());
        return Result.fail(SystemErrorType.UPLOAD_FILE_SIZE_LIMIT);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result serviceException(MethodArgumentNotValidException ex) {
        log.error("service exception:{}", ex.getMessage());
        return Result.fail(SystemErrorType.ARGUMENT_NOT_VALID, ex.getBindingResult().getFieldError().getDefaultMessage());
    }

   /* @ExceptionHandler(value = {DuplicateKeyException.class})
    public Result duplicateKeyException(DuplicateKeyException ex) {
        log.error("primary key duplication exception:{}", ex.getMessage());
        return Result.fail(SystemErrorType.DUPLICATE_PRIMARY_KEY);
    }*/

    @ExceptionHandler(value = {BaseException.class})
    public Result baseException(BaseException ex) {
        log.error("base exception:{}", ex.getMessage());
        return Result.fail(ex.getErrorType());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result exception() {
        return Result.fail();
    }

    @ExceptionHandler(value = {Throwable.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result throwable() {
        return Result.fail();
    }

}
