package com.example.shopping.sso.client.model;

import com.example.shopping.common.entity.vo.BaseModel;
import lombok.Data;


/**
 * @author alan chen
 * @version 1.0
 * @desc
 * @date 2019/12/22 13:17
 */
@Data
public class SysRole extends BaseModel {
    private String roleCode;
    private String roleName;
    private String description;
}
