package com.final2.readytomeet.config;

import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

public class filesConfig implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

      registry.addResourceHandler("/download/**")
          .addResourceLocations("file:///E:/files/")
          .setCacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES));
    }

}
