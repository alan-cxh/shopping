package com.example.shopping.common.aop;

import com.example.shopping.common.util.GsonUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 统一日志处理
 * @author: alan chen
 * @create: 2019-12-07 16:20
 */

@Aspect
@Component
//@ConfigurationProperties(prefix = "mall.advice")
public class LogAspect {

    private static Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);


    @Around(value = "execution( * com.example.shopping.*.*.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LinkedHashMap<String, Object> allParamsMap = new LinkedHashMap<>();
        Object[] args = joinPoint.getArgs();
        String[] parameterNames = signature.getParameterNames();
        for (int i = 0; i < args.length; i ++) {
            String parameterName = parameterNames[i];
            Object arg = args[i];
            if (arg == null) {
                continue;
            }
            if (arg instanceof HttpServletRequest || arg instanceof HttpServletResponse) {

            } else {
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put(parameterName, arg);
                allParamsMap.putAll(paramMap);
            }
        }
        String json = GsonUtil.BeanToJson(allParamsMap);
        String m = method.getDeclaringClass().getName() + " " + method.getName() + " ";
        LOGGER.info("start {}... params = {}", m, json);
        long startTime = System.currentTimeMillis();
        Object returnObj = joinPoint.proceed(args);
        LOGGER.info("end {}... cost = {} ms, resp = {}", m, System.currentTimeMillis() - startTime, returnObj);
        return returnObj;
    }


}
