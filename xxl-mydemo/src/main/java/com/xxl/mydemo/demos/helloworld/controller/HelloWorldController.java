package com.xxl.mydemo.demos.helloworld.controller;

import com.xxl.mydemo.demos.helloworld.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloWorldController {
    @RequestMapping("user")
    @ResponseBody
    public User myUser(@RequestBody User user, @RequestParam String sex){
        user.setSex(sex);
        return user;
    }
}
