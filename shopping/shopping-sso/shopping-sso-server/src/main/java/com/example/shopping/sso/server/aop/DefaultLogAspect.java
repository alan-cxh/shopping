package com.example.shopping.sso.server.aop;

import com.example.shopping.common.util.GsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

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
@Slf4j
public class DefaultLogAspect {



    @Around(value = "execution( * com.example.shopping.*.*.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LinkedHashMap<String, Object> allParamsMap = new LinkedHashMap<String, Object>();
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
                Map<String, Object> paramMap = new HashMap<String, Object>();
                paramMap.put(parameterName, arg);
                allParamsMap.putAll(paramMap);
            }
        }
        String json = GsonUtil.BeanToJson(allParamsMap);
        String m = method.getDeclaringClass().getName() + " " + method.getName() + " ";
        log.info("start {}... params = {}", m, json);
        long startTime = System.currentTimeMillis();
        Object returnObj = joinPoint.proceed(args);
        log.info("end {}... cost = {} ms, resp = {}", m, System.currentTimeMillis() - startTime, returnObj);
        return returnObj;
    }


}
