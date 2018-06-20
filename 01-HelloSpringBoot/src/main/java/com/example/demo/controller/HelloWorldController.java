package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description: Spring Boot test
 * @author: Mr.xweiba
 * @create: 2018-06-20 16:21
 **/
@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }
}
