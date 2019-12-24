package com.example.shopping.sso.server.model;

import com.example.shopping.common.entity.vo.BaseModel;
import lombok.Data;

/**
 * @author alan chen
 * @version 1.0
 * @desc 用户模型
 * @date 2019/12/22 13:16
 */
@Data
public class SysUser extends BaseModel {
    private String accountNo; // 账号,具有唯一性
    private String password; // 密码
    private int delFlag; // 是否删除
    private String phone; // 电话号码
    private int deptId; // 所在部门
    private String description; // 个人描述
}
