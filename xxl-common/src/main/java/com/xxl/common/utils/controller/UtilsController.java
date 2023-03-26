package com.xxl.common.utils.controller;


import com.xxl.common.utils.DateUtil;
import com.xxl.common.common.verifyParam.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/collection")
public class UtilsController {

    @RequestMapping("/judge")
    @ResponseBody
    public void addUser( ){
        List<User>  users = new LinkedList<>();
        if (!CollectionUtils.isEmpty(users)){
            System.out.println(users.size());

        }else {
            System.out.println("users为空");
        }
    }

    @RequestMapping("date")
    @ResponseBody
    public String nowDate(){
        Date date = new Date();
        return DateUtil.formatDateTime(date);
    }
}
