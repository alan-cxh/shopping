package com.example.shopping.sso.client.model;

import com.example.shopping.common.entity.vo.BaseModel;
import lombok.Data;

/**
 * @author alan chen
 * @version 1.0
 * @desc 权限名称
 * @date 2019/12/22 13:49
 */
@Data
public class SysPermission extends BaseModel {
    private String code; // 权限编码
    private String name; // 权限中文名称
}
