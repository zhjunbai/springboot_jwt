package com.example.jwt_learn.global;

import com.alibaba.fastjson.JSONObject;
import com.example.jwt_learn.util.ExceptionUtil;
import com.example.jwt_learn.util.JSONUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public JSONObject handleException(Exception e){
        System.out.println("handle error");
//        e.printStackTrace();
        Throwable ex= ExceptionUtil.getExceptionCause(e);
        return JSONUtil.failed(ex);
    }
}