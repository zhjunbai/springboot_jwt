package com.example.jwt_learn.interceptor;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public JWTInterceptor jwtInterceptor(){
        return new JWTInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        JWTInterceptor interceptor=jwtInterceptor();
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}