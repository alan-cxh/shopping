package com.example.shopping.common.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Date createTime;
    @JsonIgnore
    private Date updateTime;

}
