package com.example.shopping.demo.mapper;

import com.example.shopping.sso.client.model.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author alan chen
 * @version 1.0
 * @desc
 * @date 2019/12/25 22:17
 */
public interface UserMapper {

    @Select("select * from sys_user where account_no = #{accountNo} ")
    SysUser login(String accountNo);
}
