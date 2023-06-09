package com.final2.readytomeet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class filesConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/path/**")
                .addResourceLocations("file:///C:/filesConfig/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES));
    }

}
