package com.example.demo;

import org.springframework.stereotype.Component;

//定义一个dog，使用注解让其称为装配的Bean
@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("dog wang wang wang!!!");
    }
}
