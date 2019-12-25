package com.example.shopping.sso.client.model;

import com.example.shopping.common.entity.vo.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.NotNull;

/**
 * @author alan chen
 * @version 1.0
 * @desc 用户模型
 * @date 2019/12/22 13:16
 */
@Data
public class SysUser extends BaseModel {
    @NotNull(message = "accountNo不能为空")
    private String accountNo; // 账号,具有唯一性
    @JsonIgnore
    @NotNull(message = "password不能为空")
    private String password; // 密码
    private int delFlag; // 是否删除
    private String phone; // 电话号码
    private int deptId; // 所在部门
    private String description; // 个人描述

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, RecursiveToStringStyle.SHORT_PREFIX_STYLE);
    }
}
