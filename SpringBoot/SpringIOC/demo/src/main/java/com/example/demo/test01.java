package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test01 {
    //验证
    public static void main(String[] args) {
        //使用springboot中的context加载AppConfig配置类的内容，
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //通过context获取user实例
        BussinessPerson person = (BussinessPerson) applicationContext.getBean(BussinessPerson.class);
        person.service();

        ScopeBean s1 = applicationContext.getBean(ScopeBean.class);
        ScopeBean s2 = applicationContext.getBean(ScopeBean.class);
        System.out.println(s1 == s2);
    }
}
