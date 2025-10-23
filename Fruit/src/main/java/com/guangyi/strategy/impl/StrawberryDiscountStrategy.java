package com.guangyi.strategy.impl;

import java.math.BigDecimal;

import com.guangyi.constant.PriceConstant;
import com.guangyi.model.Fruit;
import com.guangyi.strategy.FruitSpecificStrategy;

/**
 * 草莓折扣策略
 */
public class StrawberryDiscountStrategy implements FruitSpecificStrategy {
    @Override
    public boolean isApplicable(Fruit fruit) {
        return "strawberry".equals(fruit.getName());
    }

    @Override
    public BigDecimal calculate(BigDecimal originalPrice) {
        return originalPrice.multiply(BigDecimal.valueOf(PriceConstant.STRAWBERRY_DISCOUNT_RATE));
    }
}