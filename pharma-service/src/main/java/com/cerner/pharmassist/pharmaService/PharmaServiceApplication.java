package com.cerner.pharmassist.pharmaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PharmaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmaServiceApplication.class, args);
    }
}
