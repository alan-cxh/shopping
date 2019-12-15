package com.example.shopping.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    @GetMapping("print")
    public String print(){
        return "hello demo";
    }
}
