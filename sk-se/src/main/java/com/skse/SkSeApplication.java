package com.skse;

import com.skse.framework.spring.ApplicationUtils;
import com.skse.serverio.controller.WebServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author sukang on 2019/7/30.
 */
@SpringBootApplication(scanBasePackages = {"com"},exclude = {DataSourceAutoConfiguration.class})
@RestController
public class SkSeApplication implements CommandLineRunner {


    private ApplicationContext applicationContext;

    public SkSeApplication(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(SkSeApplication.class)
                .build()
                .run(args);

        System.out.println("method1::" + applicationContext);

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("method2::" +ApplicationUtils.APPLICATION_CONTEXT);
        System.out.println("method3::" +applicationContext);
    }

    @Bean
    public ServletRegistrationBean myServlet(){

        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet(),"/index");

        return registrationBean;

    }

    @GetMapping("/test/uuid")
    public String uuid(){
        return UUID.randomUUID().toString();
    }
}
