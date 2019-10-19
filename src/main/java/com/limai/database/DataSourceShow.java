package com.limai.database;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @Author: zhangbin
 * @Date: 2019/2/14 17:20
 * @Desc:
 */
@Component
@Lazy
public class DataSourceShow implements ApplicationContextAware {
    ApplicationContext applicationContext=null;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("---------------");
        System.out.println(dataSource.getClass().getName());
        System.out.println("---------------");
    }
}
