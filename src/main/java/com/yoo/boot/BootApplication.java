package com.yoo.boot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
public class BootApplication {

    public static void main(String[] args) {
        log.warn("123");
        SpringApplication.run(BootApplication.class, args);
    }

}
