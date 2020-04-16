package com.soft1851.springboot.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Guorc
 */
@SpringBootApplication
@MapperScan("com.soft1851.springboot.mybatis.plus.mapper")
public class SpringbootMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
    }

}
