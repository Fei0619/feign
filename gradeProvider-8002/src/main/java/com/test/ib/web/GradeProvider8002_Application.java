package com.test.ib.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 费世程
 * @date 2019/8/14 15:38
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.test.ib.web.dao")
public class GradeProvider8002_Application {

  public static void main(String[] args) {
    SpringApplication.run(GradeProvider8002_Application.class,args);
  }

}
