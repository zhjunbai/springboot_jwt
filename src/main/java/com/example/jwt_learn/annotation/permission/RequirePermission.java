package com.example.jwt_learn.annotation.permission;

import com.example.jwt_learn.annotation.Logical;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequirePermission {
//    @AliasFor("value")
    String[] value();
//    @AliasFor("logical")
    Logical logical() default Logical.AND;
}