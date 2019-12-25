package com.example.shopping.sso.server.controller;

import com.example.shopping.common.entity.vo.Result;
import com.example.shopping.sso.server.form.UserForm;
import com.example.shopping.sso.client.model.SysUser;
import com.example.shopping.sso.server.service.SysUserService;
import com.example.shopping.sso.server.util.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author alan chen
 * @version 1.0
 * @desc
 * @date 2019/12/24 21:30
 */
@RestController
@RequestMapping("user")
@Slf4j
@Api("用户管理")
public class UserController {


    @Autowired
    SysUserService sysUserService;
    @Autowired
    RedisUtils redisUtils;


    @ApiOperation("新增用户")
    @PostMapping("addUser")
    public Object addUser(@RequestBody @Valid SysUser sysUser){
        sysUser = sysUserService.addUser(sysUser);
        return Result.success(sysUser);
    }


    @ApiOperation("登录")
    @PostMapping("login")
    public Object login(@RequestBody UserForm form){
        SysUser sysUser = sysUserService.login(form);
        redisUtils.set(form.getAccountNo(), sysUser);
        log.info("当前登录用户 --> {}", redisUtils.get("alan_chen"));
        return Result.success("登录成功");
    }
}
