package com.example.jwt_learn.util;

public class ExceptionUtil {
    public static Throwable getExceptionCause(Throwable e){
        while(e!=null){
            Throwable cause=e.getCause();
            if(cause==null){
                return e;
            }
            e=cause;
        }
        return null;
    }
}
