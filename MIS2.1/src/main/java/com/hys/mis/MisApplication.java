package com.hys.mis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MisApplication.class, args);
    }
}
