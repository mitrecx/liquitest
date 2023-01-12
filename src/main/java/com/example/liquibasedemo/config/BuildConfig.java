package com.example.liquibasedemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource(value = {"classpath:com/example/liquibasedemo/build.properties"})
@ConfigurationProperties(prefix = "build")
public class BuildConfig {
    private String project;
    private String version;
    private String buildNumber;
    private String timestamp;
    private String branch;
}
