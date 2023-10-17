package com.xiaoxiao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xiaoxiao.dao")
public class SofeWoreDaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SofeWoreDaoApplication.class,args);
    }

}
