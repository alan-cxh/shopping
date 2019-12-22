package com.example.shopping.sso.server.model;

import com.example.shopping.common.entity.vo.BaseModel;
import lombok.Data;

/**
 * @author alan chen
 * @version 1.0
 * @desc 微服务名称
 * @date 2019/12/22 13:44
 */
@Data
public class SysApp extends BaseModel {
    private String appCode; // 服务编码
    private String serviceName; // 服务中文名称
}
