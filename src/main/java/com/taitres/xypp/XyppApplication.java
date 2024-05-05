package com.taitres.xypp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.taitres.xypp.mapper")
@EnableScheduling
public class XyppApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyppApplication.class, args);
    }

}
