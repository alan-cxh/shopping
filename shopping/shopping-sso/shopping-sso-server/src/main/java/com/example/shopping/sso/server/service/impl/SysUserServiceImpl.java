package com.example.shopping.sso.server.service.impl;

import com.example.shopping.common.exception.ServiceException;
import com.example.shopping.common.exception.SystemType;
import com.example.shopping.sso.server.dao.SysUserMapper;
import com.example.shopping.sso.server.exception.SsoServiceException;
import com.example.shopping.sso.server.form.UserForm;
import com.example.shopping.sso.client.model.SysUser;
import com.example.shopping.sso.server.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author alan chen
 * @version 1.0
 * @desc
 * @date 2019/12/22 13:11
 */
@Service
@Transactional
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Autowired(required = false)
    private SysUserMapper sysUserMapper;
    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public SysUser login(UserForm form) {
        SysUser sysUser = sysUserMapper.login(form.getAccountNo());
        if (sysUser == null) {
            throw new ServiceException("用户" + form.getAccountNo() +"不存在");
        }
        // 密码校验
        if (!encoder.matches(form.getPassword(), sysUser.getPassword())) {
            throw new ServiceException("密码不正确，登录失败");
        };
        return sysUser;
    }

    @Override
    public SysUser addUser(SysUser sysUser) {
        try {
            sysUser.setPassword(encoder.encode(sysUser.getPassword()));
            sysUserMapper.insert(sysUser);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SsoServiceException(SystemType.ADD_ERROR);
        }
        return sysUser;
    }
}
