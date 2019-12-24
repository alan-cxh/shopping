package com.example.shopping.sso.server.service;

import com.example.shopping.sso.server.form.UserForm;
import com.example.shopping.sso.server.model.SysUser;

/**
 * @author alan chen
 * @version 1.0
 * @desc
 * @date 2019/12/22 13:10
 */
public interface SysUserService {
    SysUser login(UserForm form);
}
