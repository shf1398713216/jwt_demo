package com.example.jwtdemo.testcontroller;

import com.example.jwtdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/gencentToken")
    public Object test(HttpServletRequest request) {

        return testService.test();
    }


}
