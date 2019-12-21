package com.example.shopping.common.enumeration;

public enum RunCodeEnum {

    SYS_RUN_SUCCESS(1001, "请求成功"),
    SYS_RUN_ERROR(1002, "请求失败"),
    SYS_PARAMETER_ERROR(1003, "请求失败"),
    SYS_RUNTION_EXCEPTION(1004, "系统错误")
    ;

    RunCodeEnum(){

    }
    RunCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
