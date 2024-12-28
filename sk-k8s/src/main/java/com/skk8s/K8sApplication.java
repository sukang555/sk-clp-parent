package com.skk8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author sukang
 */
@SpringBootApplication(exclude = {KafkaAutoConfiguration.class})
@ComponentScans(value = {@ComponentScan(value = {"com"})})
public class K8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(K8sApplication.class, args);

    }

}
