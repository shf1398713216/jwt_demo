package com.example.jwtdemo.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    private int a=1;

    public   String  test(){

        try {
            System.out.println("接受到请求了"+Thread.currentThread().getName());
            Thread.sleep(10000);
            if (a == 1) {

                --a;
                System.out.println(a);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "123";
    }




}
