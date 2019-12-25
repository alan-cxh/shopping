package com.example.shopping.demo.service;

import com.example.shopping.demo.form.UserForm;
import com.example.shopping.demo.mapper.UserMapper;
import com.example.shopping.sso.client.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alan chen
 * @version 1.0
 * @desc
 * @date 2019/12/25 22:19
 */
@Service
public class UserService {

    @Autowired(required = false)
    UserMapper userMapper;

    public void login(UserForm userForm){
        SysUser sysUser = userMapper.login(userForm.getAccountNo());

    }
}
