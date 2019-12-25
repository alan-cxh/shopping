package com.example.shopping.demo.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author alan chen
 * @version 1.0
 * @desc
 * @date 2019/12/22 16:24
 */
@Data
public class UserForm implements Serializable {
    @NotNull(message = "帐号不能为空")
    private String accountNo;
    @NotNull(message = "密码不能为空")
    private String password;

    public String getAccountNo() {
        return accountNo;
    }

    public String getPassword() {
        return password;
    }
}
