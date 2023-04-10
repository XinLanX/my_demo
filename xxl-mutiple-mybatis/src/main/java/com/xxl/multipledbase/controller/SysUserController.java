package com.xxl.multipledbase.controller;

import com.xxl.multipledbase.util.MultiDBProperties;
import com.xxl.multipledbase.entity.SysUser;
import com.xxl.multipledbase.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Properties;

@Controller
@RequestMapping("/user")
@Slf4j
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/list")
    @ResponseBody
    public List<SysUser> list(){
        List<SysUser> sysUsers = sysUserService.sysUserList();
        return sysUsers;
    }
    @RequestMapping("/list1")
    @ResponseBody
    public List<SysUser> list1(){
//        String sql = "select user_id, login_name, email, user_name from sys_user";
        List<SysUser> sysUsers = sysUserService.sysUserList1();
        return sysUsers;
    }
    @RequestMapping("/prop")
    @ResponseBody
    public String prop(){
        Properties properties = MultiDBProperties.getProperties();
        String s = properties.getProperty("unif.rdb.default.url");
        return s;
    }

}
