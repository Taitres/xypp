package com.taitres.xypp;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.taitres.xypp.mapper")
public class XyppApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyppApplication.class, args);
    }

}
