package com.xxl.common.common.strategyFactory.payStrategy.payFunc;

import com.xxl.common.common.strategyFactory.payStrategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("alipayPay")
public class AlipayPayStrategy implements PayStrategy {

    @Override
    public Long discountPayMoney(Long money){
        long price = money;
        if (money >= 80){
            price -= 20;
        }else if (money >=  40){
            price -= 10;
        }
        return price;
    }

}
