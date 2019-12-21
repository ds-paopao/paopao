package com.czxy.paopao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.czxy.paopao.dao")
public class UserFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserFeignApplication.class,args);
    }
}
