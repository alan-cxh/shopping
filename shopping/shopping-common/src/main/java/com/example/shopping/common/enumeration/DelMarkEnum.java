package com.example.shopping.common.enumeration;

import lombok.Getter;


/**
 * @author alan chen
 * @version 1.0
 * @desc 删除状态
 * @date 2019/12/22 13:58
 */
@Getter
public enum DelMarkEnum {

    YES(1, "删除"),
    No(0, "正常")

    ;
    private int code;
    private String message;

    DelMarkEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
