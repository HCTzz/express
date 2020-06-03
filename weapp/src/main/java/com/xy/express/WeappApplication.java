package com.xy.express;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.ServletContext;

/**
 * @author Administrator
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.xy.express.*")
public class WeappApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeappApplication.class, args);
    }

    public void test(ApplicationContext context){
    }
}
