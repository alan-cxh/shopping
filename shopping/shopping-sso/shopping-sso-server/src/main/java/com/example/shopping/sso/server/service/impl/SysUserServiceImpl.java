package com.example.shopping.sso.server.service.impl;

import com.example.shopping.common.exception.ServiceException;
import com.example.shopping.sso.server.dao.SysUserMapper;
import com.example.shopping.sso.server.form.UserForm;
import com.example.shopping.sso.server.model.SysUser;
import com.example.shopping.sso.server.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author alan chen
 * @version 1.0
 * @desc
 * @date 2019/12/22 13:11
 */
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser login(UserForm form) {
        SysUser sysUser = sysUserMapper.validLogin(form);
        if (sysUser == null) {
            throw new ServiceException("用户不存在");
        }
        return sysUser;
    }
}
