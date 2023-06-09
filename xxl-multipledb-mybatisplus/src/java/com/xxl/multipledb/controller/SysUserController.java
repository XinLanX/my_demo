package com.xxl.multipledb.controller;

//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.xxl.multipledb.config.DataS;
import com.xxl.multipledb.entity.SysUser;
import com.xxl.multipledb.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.sql.DataSourceDefinition;
import java.util.List;

@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/list")
    @ResponseBody
    public List<SysUser> list(){
//        PageHelper.startPage(1,5);
        List<SysUser> sysUsers = sysUserService.sysUserList();
//        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(sysUsers);
        return sysUsers;
    }

    @GetMapping("/list1")
    @ResponseBody
    public List<SysUser> list1(){
        return sysUserService.sysUserList1();
    }
}
