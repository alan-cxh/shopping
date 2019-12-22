package com.example.shopping.sso.server.form;

import lombok.Data;

import java.io.Serializable;

/**
 * @author alan chen
 * @version 1.0
 * @desc
 * @date 2019/12/22 16:24
 */
@Data
public class UserForm implements Serializable {
    private String accountNo;
    private String password;
}
