package com.limai.database.common.config.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ExecutorConfig {
    private final static Logger logger= LoggerFactory.getLogger(ExecutorConfig.class);
    @Bean("asyncServiceExecutor")
    public Executor asyncServiceExecutor(){
        logger.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        VisibleThreadPoolTaskExecutor threadPoolTaskExecutor = new VisibleThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setKeepAliveSeconds(100);
        threadPoolTaskExecutor.setQueueCapacity(101000);
        threadPoolTaskExecutor.setThreadNamePrefix("async-service-");
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
