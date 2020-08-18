package com.limai.database;

import com.limai.database.common.mq.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;

@EnableScheduling
@SpringBootApplication
public class DatabaseApplication {

    @Autowired
    private KafkaProducer kafkaProducer;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

//    @PostConstruct
    public void init() {
        kafkaProducer.send();
    }

    /**
     * 解决特殊字符问题
     */
    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {

        // 修改内置的 tomcat 容器配置
        TomcatServletWebServerFactory tomcatServlet = new TomcatServletWebServerFactory();
        tomcatServlet.addConnectorCustomizers(
                (TomcatConnectorCustomizer) connector -> connector.setProperty("relaxedQueryChars", "[]{}")
        );

        return tomcatServlet;
    }
}
