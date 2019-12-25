package com.example.shopping.demo.controller;

import com.example.shopping.common.entity.vo.Result;
import com.example.shopping.demo.config.RedisUtils;
import com.example.shopping.demo.form.UserForm;
import com.example.shopping.demo.service.UserService;
import com.example.shopping.sso.client.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("demo")
public class DemoController {


    @Autowired
    UserService userService;
    @Autowired
    RedisUtils redisUtils;

    @GetMapping("print")
    public String print(){
        return "hello demo";
    }

    @PostMapping("login")
    public Object login(@RequestBody UserForm userForm){
        SysUser sysUser = (SysUser) redisUtils.get(userForm.getAccountNo());
        if (sysUser != null) {
            return Result.success(sysUser);
        }
        log.info("redis中不存在，需要重新登录，请跳转到登录界面");
        return Result.fail("登录失效，请跳转至sso-server重新登录");
    }
}
