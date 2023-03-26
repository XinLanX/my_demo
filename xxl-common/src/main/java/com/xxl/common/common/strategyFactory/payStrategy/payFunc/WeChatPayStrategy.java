package com.xxl.common.common.strategyFactory.payStrategy.payFunc;

import com.xxl.common.common.strategyFactory.payStrategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("weChatPay")
public class WeChatPayStrategy implements PayStrategy {
    @Override
    public Long discountPayMoney(Long money){
        long price = money;
        price -= 5;
        if (money >= 50){
            price -= 10;
        }else if (money >=  30){
            price -= 30;
        }
        return price;
    }
}
