package com.siemens.useraccountapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UserAccountApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserAccountApiApplication.class, args);
    }

}
