//package com.final2.readytomeet.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebMvcConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**") // 모든 경로에 인터셉터 적용
//                .excludePathPatterns("/login", "/logout"); // 로그인과 로그아웃 경로는 제외
//    }
//}
//
