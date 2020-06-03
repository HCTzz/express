package com.xy.express.config.Interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description
 * @auther HHF
 * @create 2020-06-03 下午 3:14
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public XyInterceptor xyInterceptor(){
        return new XyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(xyInterceptor());
    }

}
