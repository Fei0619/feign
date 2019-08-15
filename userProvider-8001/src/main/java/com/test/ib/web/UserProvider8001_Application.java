package com.test.ib.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author 费世程
 * @date 2019/8/14 13:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.test.ib.web.dao")
@EnableFeignClients(basePackages = "com.test.ib.web.openfeign")
public class UserProvider8001_Application {

  public static void main(String[] args) {
    SpringApplication.run(UserProvider8001_Application.class,args);
  }

}
