package com.example.shopping.common.exception;

import lombok.Getter;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author alan chen
 * @version 1.0
 * @desc
 * @date 2019/12/24 21:55
 */
@Getter
public enum SystemType {

    ADD_ERROR("新增数据失败");
    ;
    private String message;

    SystemType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, RecursiveToStringStyle.SHORT_PREFIX_STYLE);
    }
}
