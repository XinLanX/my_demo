package com.xxl.common.common.exception.controller;


import com.xxl.common.common.exception.UnifI18NException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("/exception")
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        String s = "s";
        if("s".equals(s)){
            throw  UnifI18NException.of("出错了！");
        }
        return s;
    }
}
