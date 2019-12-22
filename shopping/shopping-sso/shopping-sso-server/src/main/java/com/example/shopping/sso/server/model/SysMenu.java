package com.example.shopping.sso.server.model;

import com.example.shopping.common.entity.vo.BaseModel;
import lombok.Data;

/**
 * @author alan chen
 * @version 1.0
 * @desc 菜单
 * @date 2019/12/22 13:30
 */
@Data
public class SysMenu extends BaseModel {
    private String menuCode; // 菜单code
    private String menuName; // 菜单中文名称
    private Long parentId; // 父菜单
    private Long appId; // 附属于app服务
}
