package com.xxl.myoracle.keysequence.controller;

import com.xxl.myoracle.keysequence.domain.DevApplication;
import com.xxl.myoracle.keysequence.service.IDevApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/app")
public class DevApplicationController{
    @Autowired
    private IDevApplicationService devApplicationService;

    @PostMapping("list")
    @ResponseBody
    public List<DevApplication> list(){
        return devApplicationService.list();
    }

    @PostMapping("save")
    @ResponseBody
    public void insertDevApp(@RequestBody DevApplication devApplication){
        devApplicationService.save(devApplication);
    }
}
