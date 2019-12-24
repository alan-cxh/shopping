package com.example.shopping.sso.server.controller;

import com.example.shopping.common.entity.vo.Result;
import com.example.shopping.sso.server.form.UserForm;
import com.example.shopping.sso.server.model.SysUser;
import com.example.shopping.sso.server.service.SysUserService;
import com.example.shopping.sso.server.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("user")
@Api(tags = "系统登陆")
public class LoginController {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    private StringRedisTemplate template;

    @ApiOperation("登录")
    @PostMapping("login")
    public Object login(@RequestBody UserForm form){
        SysUser sysUser = sysUserService.login(form);
        redisUtils.set("alan_chen", sysUser);
        redisUtils.get("alan_chen");
        return Result.success(sysUser);
    }
}
