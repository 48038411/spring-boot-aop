package com.soft1851.springboot.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Guorc
 */
@SpringBootApplication
@ComponentScan("com.soft1851.springboot.jwt.*")
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

}
