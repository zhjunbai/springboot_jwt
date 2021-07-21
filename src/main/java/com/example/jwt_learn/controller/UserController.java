package com.example.jwt_learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.jwt_learn.annotation.permission.PassToken;
import com.example.jwt_learn.annotation.permission.RequirePermission;
import com.example.jwt_learn.entity.User;
import com.example.jwt_learn.service.PermissionService;
import com.example.jwt_learn.service.UserService;
import com.example.jwt_learn.util.JSONKeyEnum;
import com.example.jwt_learn.util.JSONUtil;
import com.example.jwt_learn.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @RequirePermission("user:add")
    @RequestMapping("/add")
    public JSONObject add(@RequestBody User user){
        return JSONUtil.success();
    }
    @PassToken
    @RequestMapping("/login")
    public JSONObject login(@RequestBody User user){
        User data=userService.findUserByUsername(user.getUsername());
        if(data.getPassword().equals(user.getPassword())){
            JSONObject jsonObject=JSONUtil.success();
            jsonObject.put(JSONKeyEnum.TOKEN.getKey(), TokenUtil.getToken(data));
            System.out.println("登录成功");
            return jsonObject;
        }else{
            return JSONUtil.failed("登录失败");
        }
    }
}