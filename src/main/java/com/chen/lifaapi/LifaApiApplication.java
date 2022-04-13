package com.chen.lifaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@EnableScheduling //开启定时任务
@SpringBootApplication
public class LifaApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(LifaApiApplication.class, args);
    }

}
