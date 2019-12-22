package com.example.shopping.sso.server.controller;

import com.example.shopping.sso.server.form.UserForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @GetMapping("login")
    public Object login(@RequestBody UserForm userForm){
        log.info("hello world sso : {}", userForm);
        return null;
    }
}
