package com.ling.shop;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo(scanBasePackages = {"com.ling.shop"})
public class GoodsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsServiceApplication.class,args);
    }

}
