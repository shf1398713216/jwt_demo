package com.example.jwtdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private BaseInterceptor baseInterceptor;

    /**
     * 针对所有的请求，增加一个获取header数据的解析
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加路径
        registry.addInterceptor(baseInterceptor)
//                .excludePathPatterns("/api/login")   不拦截路径
                .addPathPatterns("/miniApp/**");        //拦截路径

    }
}
