package com.lhzn.soft;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 场站信息上传
 * @author gstarqs
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableAsync
@EnableScheduling
public class MQCliApplication {

    public static void main(String[] args) {
        SpringApplication.run(MQCliApplication.class, args);
        System.out.println("服务启动成功");
    }

}
