package com.example.shopping.consulService;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "student") //对应consul配置中心上 student 前缀开始的配置信息
public class StudentConfig {

    private String name;
    private int age;
    private String sex;


    @Override
    public String toString() {
        return "StudentConfig{" + "name='" + name + '\'' + ", age=" + age + ", sex='" + sex + '\'' + '}';
    }

}
