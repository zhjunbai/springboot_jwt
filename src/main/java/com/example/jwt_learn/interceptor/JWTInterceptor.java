package com.example.jwt_learn.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwt_learn.annotation.permission.PassToken;
import com.example.jwt_learn.entity.User;
import com.example.jwt_learn.service.PermissionService;
import com.example.jwt_learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Set;

public class JWTInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("token");
        if(handler instanceof HandlerMethod handlerMethod){
            Method method=handlerMethod.getMethod();
            if(method.isAnnotationPresent(PassToken.class)){
                System.out.println("跳过token验证");
                return true;
            }else{
                if(null!=token&& !token.equals("")){
                    String username;
                    try {
                        username = JWT.decode(token).getAudience().get(0);
                    }catch (Exception e){
                        throw new Exception("token异常");
                    }
                    System.out.println(username);
                    User user=userService.findUserByUsername(username);
                    if (null!=user){
                        request.setAttribute("user",user);
                        Set<String> permissions=permissionService.findPermissionsByUsername(user.getUsername());
                        request.setAttribute("permissions",permissions);
                        JWTVerifier verifier=JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                        try {
                            verifier.verify(token);
                        }catch (Exception e){
                            return false;
                        }
                        return true;
                    }else{
                        throw new Exception("token异常");
                    }
                }else{
                    User user=new User();
                    user.setUsername("anon");
                    request.setAttribute("user",user);
                    return true;
                }
            }
        }else{
            return true;
        }
    }
}
