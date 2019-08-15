package com.test.ib.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 费世程
 * @date 2019/8/14 11:04
 */
@SpringBootApplication
@EnableEurekaServer //EurekaServer服务端启动类，接受其他微服务注册进来
public class Eureka7001_Application {

  public static void main(String[] args) {
    SpringApplication.run(Eureka7001_Application.class,args);
  }

}
