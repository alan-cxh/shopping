package com.example.shopping.sso.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @GetMapping("login")
    public Object login(String username){
        log.info("hello world sso : {}", username);
        return null;
    }
}
