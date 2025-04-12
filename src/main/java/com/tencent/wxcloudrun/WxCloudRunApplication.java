package com.tencent.wxcloudrun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableCaching
@ComponentScan(basePackages={"com.github.niefy","com.tencent.wxcloudrun"})
@MapperScan(basePackages = {"com.tencent.wxcloudrun.dao", "com.github.niefy.modules.*.dao"})
public class WxCloudRunApplication {  

  public static void main(String[] args) {
    SpringApplication.run(WxCloudRunApplication.class, args);
  }
}
