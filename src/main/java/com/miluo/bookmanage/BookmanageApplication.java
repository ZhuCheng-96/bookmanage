package com.miluo.bookmanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.miluo.bookmanage.dao"})
public class BookmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmanageApplication.class, args);
    }

}
