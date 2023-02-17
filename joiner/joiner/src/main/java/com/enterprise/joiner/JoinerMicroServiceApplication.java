package com.enterprise.joiner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class JoinerMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(JoinerMicroServiceApplication.class, args);
    }

}
