package com.example.shopping.sso.server.dao;

import com.example.shopping.sso.server.form.UserForm;
import com.example.shopping.sso.server.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author alan chen
 * @version 1.0
 * @desc SysUserMapper
 * @date 2019/12/22 14:27
 */
@Mapper
public interface SysUserMapper {

    @Select("select * from sys_user where account_no = #{f.accountNo} and password = #{f.password} ")
    SysUser validLogin(@Param("f") UserForm form);
}
