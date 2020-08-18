package com.limai.database.common.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @Author: zhangbin
 * @Date: 2019/6/6 8:40
 * @Desc:
 */
@Component
public class ApplicationContextPrividerConfig implements ApplicationContextAware {
    private static ApplicationContext context;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context=applicationContext;
    }

    public static <T>T getBean(String className,Class<T> aClass){
        return context.getBean(className,aClass);
    }

    public Map<String, Object> getBeanByAnnotation(Class<? extends  Annotation> clazz){
        return context.getBeansWithAnnotation(clazz);
    }
}
