package com.example.shopping.sso.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.example.shopping.sso.server.dao")
public class SsoServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SsoServerApplication.class, args);
    }

   /* @Bean
    RedisTemplate<String, Object> redisTemplate(){
        return new RedisTemplate<>();
    }*/
}
