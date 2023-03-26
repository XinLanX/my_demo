package com.xxl.common.common.strategyFactory.controller;

import com.xxl.common.common.strategyFactory.payStrategy.PayFactory;
import com.xxl.common.common.strategyFactory.payStrategy.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/pay")
public class PaySFController {
    @Autowired
    private PayFactory payFactory;

    @RequestMapping(value = "/pay")
    @ResponseBody
    public Long pay(Integer plat){
        PayStrategy alipayPay = payFactory.getStrategy("alipayPay");
        Long price = alipayPay.discountPayMoney(10000L);
        return price;
    }
}
