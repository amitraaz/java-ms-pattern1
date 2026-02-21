package com.tutorial.servicec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceCApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCApplication.class, args);
    }
}
