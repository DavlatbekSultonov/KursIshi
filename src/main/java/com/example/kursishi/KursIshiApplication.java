package com.example.kursishi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KursIshiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KursIshiApplication.class, args);
    }

}
