package com.xxl.common.common.strategyFactory.payStrategy.payFunc;

import com.xxl.common.common.strategyFactory.payStrategy.PayStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("unionpayPay")
public class UnionpayPayStrategy implements PayStrategy {
    @Override
    public Long discountPayMoney(Long money){
        long price = money;
        price -= 10;
        return price;
    }
}
