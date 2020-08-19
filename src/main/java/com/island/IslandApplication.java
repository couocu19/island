package com.island;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication(scanBasePackages = "com")
@MapperScan(basePackages = "com.dao")
public class IslandApplication {

    public static void main(String[] args) {
        SpringApplication.run(IslandApplication.class, args);
    }
}
