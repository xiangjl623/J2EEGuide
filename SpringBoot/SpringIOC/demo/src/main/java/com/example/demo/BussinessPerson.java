package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//定义人，实现人接口。
@Component
public class BussinessPerson implements Person {

    private Animal animal = null;

    @Override
    public void service() {
        animal.use();
    }

    @Override
    @Autowired
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
