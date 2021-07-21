package com.example.jwt_learn.util;

import com.alibaba.fastjson.JSONObject;

public class JSONUtil {
    public static JSONObject getJSONTemplate(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put(JSONKeyEnum.RESULT.getKey(),null);
        jsonObject.put(JSONKeyEnum.CODE.getKey(), null);
        jsonObject.put(JSONKeyEnum.MSG.getKey(), null);
        jsonObject.put(JSONKeyEnum.DATA.getKey(), null);
        jsonObject.put(JSONKeyEnum.ERROR.getKey(), null);
        jsonObject.put(JSONKeyEnum.TOKEN.getKey(), null);
        return jsonObject;
    }
    public static JSONObject success(){
        JSONObject jsonObject=getJSONTemplate();
        jsonObject.put(JSONKeyEnum.CODE.getKey(), 200);
        jsonObject.put(JSONKeyEnum.RESULT.getKey(), "success");
        return jsonObject;
    }
    public static JSONObject success(Object data){
        JSONObject jsonObject=getJSONTemplate();
        jsonObject.put(JSONKeyEnum.CODE.getKey(), 200);
        jsonObject.put(JSONKeyEnum.RESULT.getKey(), "success");
        jsonObject.put(JSONKeyEnum.DATA.getKey(),data);
        return jsonObject;
    }
    public static JSONObject failed(Throwable e){
        JSONObject jsonObject=getJSONTemplate();
        jsonObject.put(JSONKeyEnum.CODE.getKey(), 500);
        jsonObject.put(JSONKeyEnum.RESULT.getKey(), "failed");
        jsonObject.put(JSONKeyEnum.ERROR.getKey(),e);
        jsonObject.put(JSONKeyEnum.MSG.getKey(), e.getMessage());
        return jsonObject;
    }
    public static JSONObject failed(String msg){
        JSONObject jsonObject=getJSONTemplate();
        jsonObject.put(JSONKeyEnum.CODE.getKey(), 500);
        jsonObject.put(JSONKeyEnum.RESULT.getKey(), "failed");
        jsonObject.put(JSONKeyEnum.ERROR.getKey(),null);
        jsonObject.put(JSONKeyEnum.MSG.getKey(), msg);
        return jsonObject;
    }
}
