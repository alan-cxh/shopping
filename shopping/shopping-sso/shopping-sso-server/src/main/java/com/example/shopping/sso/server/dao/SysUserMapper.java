package com.example.shopping.sso.server.dao;

import com.example.shopping.sso.server.form.UserForm;
import com.example.shopping.sso.client.model.SysUser;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from sys_user where account_no = #{accountNo} ")
    SysUser login(String accountNo);

    @Insert("insert sys_user (account_no, password) values( #{s.accountNo}, #{s.password})")
    @Options(useGeneratedKeys = true, keyColumn = "#{s.id}")
    void insert(@Param("s") SysUser sysUser);
}
