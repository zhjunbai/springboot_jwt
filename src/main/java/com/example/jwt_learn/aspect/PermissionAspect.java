package com.example.jwt_learn.aspect;

import com.example.jwt_learn.annotation.permission.RequirePermission;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Set;

@Aspect
@Component
public class PermissionAspect {
    @Pointcut("@annotation(com.example.jwt_learn.annotation.permission.RequirePermission)")
    public void permission(){}
    @Before("permission()")
    public void before(JoinPoint joinPoint) throws Exception {
        RequestAttributes attributes= RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request=(HttpServletRequest) attributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        assert request != null;
        if(null!=request.getAttribute("user")){
            System.out.println("aspect");
            if(null!=request.getAttribute("permissions")) {
                Set<String> permissions = (Set<String>) request.getAttribute("permissions");
                Signature signature = joinPoint.getSignature();
                MethodSignature methodSignature = (MethodSignature) signature;
                Method method = methodSignature.getMethod();
                Method targetMethod = null;
                try {
                    targetMethod = joinPoint.getTarget().getClass().getMethod(method.getName(), method.getParameterTypes());
                } catch (NoSuchMethodException e) {
                    throw e;
                }
                RequirePermission permission = targetMethod.getAnnotation(RequirePermission.class);
                String[] permissionslist = null;
                if (permission != null) {
                    permissionslist = permission.value();
                }
                assert permissionslist != null;
                for (String per : permissionslist) {
                    if (!permissions.contains(per)) {
                        throw new Exception("权限不足");
                    }
                }
            }else{
                throw new Exception("权限不足");
            }
        }else{
            throw new Exception("出现异常");
        }
    }
}