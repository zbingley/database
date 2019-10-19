package com.limai.database.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: zhang bin
 * @date: 2019/8/27
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate  restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
