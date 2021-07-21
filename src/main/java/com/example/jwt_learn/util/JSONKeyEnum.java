package com.example.jwt_learn.util;

public enum JSONKeyEnum {
    RESULT("result"),
    CODE("code"),
    MSG("msg"),
    DATA("data"),
    ERROR("error"),
    TOKEN("token");
    private String key;
    private JSONKeyEnum(String key){
        this.key=key;
    }
    public String getKey(){
        return key;
    }
}