package com.xxl.common.common.verifyParam.controller;

import com.xxl.common.common.verifyParam.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/addUser")
    @ResponseBody
    public User addUser(@RequestBody @Valid User user){
        System.out.println(String.format("用户姓名为： %s",user.getName()) );
        System.out.println(String.format("用户身份证号为： %s",user.getIdCardNo()));
        return user;
    }

    @RequestMapping(value = "/addTest")
    @ResponseBody
    public void addMH(){
        User user = new User();
        user.setName("xinlan");
        addMe(user);
        User user1 = new User();
        user1.setName("xinlan");
        user1.setIdCardNo("360122");
        addMe(user1);
    }

    private void  addMe( User user){
        System.out.println(user.getName());
        System.out.println(user.getIdCardNo());
    }

}
