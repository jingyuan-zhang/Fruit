package com.guangyi.strategy.impl;

import java.math.BigDecimal;

import com.guangyi.model.Fruit;
import com.guangyi.strategy.FruitSpecificStrategy;

/**
 * 特定水果折扣策略
 */
public class SpecificFruitDiscountStrategy implements FruitSpecificStrategy {
    private final String fruitName;
    private final double discountRate;

    /**
     * 构造方法
     *
     * @param fruitName    水果名称
     * @param discountRate 折扣率
     */
    public SpecificFruitDiscountStrategy(String fruitName, double discountRate) {
        this.fruitName = fruitName;
        this.discountRate = discountRate;
    }

    @Override
    public boolean isApplicable(Fruit fruit) {
        return fruitName.equals(fruit.getName());
    }

    @Override
    public BigDecimal calculate(BigDecimal originalPrice) {
        return originalPrice.multiply(BigDecimal.valueOf(discountRate));
    }
}