package com.sk.netty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author sukang
 */
@SpringBootApplication(scanBasePackages = {"com.sk.netty"})
@EnableConfigurationProperties
@ConfigurationPropertiesScan(basePackages = {"com.sk.netty"})
public class SkNettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkNettyApplication.class, args);
    }

}
