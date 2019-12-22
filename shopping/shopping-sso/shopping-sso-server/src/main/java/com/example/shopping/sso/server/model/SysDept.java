package com.example.shopping.sso.server.model;

import com.example.shopping.common.entity.vo.BaseModel;
import lombok.Data;

/**
 * @author alan chen
 * @version 1.0
 * @desc 部门模型
 * @date 2019/12/22 13:46
 */
@Data
public class SysDept extends BaseModel {
    private String name; // 部门名称
    private String description; // 部门描述
    private Long parentId; // 父部门
}
