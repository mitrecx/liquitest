package com.example.liquibasedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class LiquibaseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiquibaseDemoApplication.class, args);
    }

    @Bean
    public Properties buildProperty() throws IOException {
        Properties buildInfo = new Properties();
        buildInfo.load(LiquibaseDemoApplication.class.getResourceAsStream("build.properties"));
        return buildInfo;
    }

}
