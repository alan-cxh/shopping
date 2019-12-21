package com.example.shopping.sso.client.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("login")
    public Object login(){

        return null;
    }
}
