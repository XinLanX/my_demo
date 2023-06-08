package com.xxl.common.common.exceptionDefine.controller;

import com.xxl.common.common.exceptionDefine.SelfDefineException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/except")
public class ExceptionController {

    @RequestMapping("/test")
    @ResponseBody
    public void test() throws SelfDefineException {
            throw new SelfDefineException("xxx");
    }

}
