package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserLogin;
@CrossOrigin
@RestController
@RequestMapping(value = "/")
public class MainController {
    @GetMapping(value = "/")
    public String mainPage() {
        return "Hello world";
    }

    @GetMapping(value = "/tesouro-nacional")
    public String getTesouroNacional() {
        return "1 bilhão de bitcoins";
    }

    @GetMapping(value = "/testando-http")
    public ResponseEntity<Object> getTestandoHttp() {
        return new ResponseEntity<>("ratinho", HttpStatus.BAD_GATEWAY);
    }

    @GetMapping(value = "/testando-query-params")
    public String queryParams(@RequestParam(value = "name") String name) {
        return "meu nome é " + name;
    }

    @GetMapping(value = "testando-query-params-default")
    public String queryWithDefaultParams(@RequestParam(value = "name", defaultValue = "Abner trovão") String name,
            @RequestParam(value = "age") int age) {
        return "Meu nome é " + name + ", e tenho " + age + " anos.";
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@RequestBody UserLogin body) {
        String responseMessage = "Username: " + body.getUsername() + " Password: " + body.getPassword();
        return new ResponseEntity<>(responseMessage,HttpStatus.OK);
    }
}