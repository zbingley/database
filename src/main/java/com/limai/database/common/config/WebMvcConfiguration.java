package com.limai.database.common.config;

import com.limai.database.common.security.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器配置类
 *
 * @author Zhang bin
 * @version [版本号, 2020/5/28 15:56]
 */

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private TokenInterceptor tokenInterceptor;

    private static final String[] excludePathPatterns = {"/users/login"};

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns(excludePathPatterns);
    }
}
