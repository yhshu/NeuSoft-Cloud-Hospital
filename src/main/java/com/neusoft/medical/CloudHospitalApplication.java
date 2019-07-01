package com.neusoft.medical;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@MapperScan(basePackages = "com.neusoft.medical.dao")
@EnableConfigurationProperties
@EnableWebSecurity
public class CloudHospitalApplication {
    private static Logger logger = Logger.getLogger(CloudHospitalApplication.class);

    /**
     * 允许传输特定字符
     * @return 可配置 servlet web 服务器工厂
     */
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> connector.setProperty("relaxedQueryChars", "|{}[]"));
        return factory;
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudHospitalApplication.class, args);
        logger.info("SpringBoot main function has started...");
    }
}