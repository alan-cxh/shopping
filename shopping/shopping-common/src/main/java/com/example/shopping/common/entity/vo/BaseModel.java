package com.example.shopping.common.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author alan chen
 * @version 1.0
 * @desc Model的基本模型
 * @date 2019/12/22 13:18
 */
@Data
public class BaseModel implements Serializable {
    private Long id;
    private int delMark; // 删除标记, 0：正常，1：删除
    private Date createTime;
    private Date updateTime;

}
