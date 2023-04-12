package com.xxl.mydemo.demos.helloworld.controller;

import com.xxl.mydemo.demos.helloworld.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("hello")
public class HelloWorldController {

//    @Value("${spring.datasource.default.url}")
//    private String myUrl;

    @RequestMapping("user")
    @ResponseBody
    public User myUser(@RequestBody User user, @RequestParam String sex){
        user.setSex(sex);
        return user;
    }

    @RequestMapping("users")
    @ResponseBody
    public User myUser1(){
        User user1 = new User();
        user1.setUserName("xinlan");
        user1.setAge("18");
        user1.setSex("man");
        return user1;
    }

    @RequestMapping("yml")
    @ResponseBody
    public Map getYmlPro(){
        Class<?> clazz = HelloWorldController.class;
        InputStream inputStream = clazz.getResourceAsStream("/application.yml");
        Yaml yaml = new Yaml();
        Map<String, Object> yamlData = yaml.load(inputStream);
        return yamlData;
    }

}
