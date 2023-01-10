package com.example.jwtdemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JwTdemoApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
        String name = "二哥";
        modify(name);
        System.out.println("name=======" + name);
        String test = "{\"name\": \"18\",\"age\": 28" +
                "}";

    }


    private static void modify(String name1) {
        name1 = "三妹";
        System.out.println("name1=====" + name1);
    }


}
