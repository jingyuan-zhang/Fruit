package com.guangyi.model;

import java.math.BigDecimal;

import com.guangyi.strategy.PricingStrategy;

/**
 * 水果抽象类
 */
public abstract class AbstractFruit implements Fruit {
    private final String name;
    private final BigDecimal pricePerKg;
    private final int weight;

    /**
     * 构造方法
     *
     * @param name       水果名称
     * @param pricePerKg 单价（元/斤）
     * @param weight     重量（斤）
     */
    public AbstractFruit(String name, double pricePerKg, int weight) {
        this.name = name;
        this.pricePerKg = BigDecimal.valueOf(pricePerKg);
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPricePerKg() {
        return pricePerKg;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public BigDecimal calculatePrice(PricingStrategy strategy) {
        BigDecimal originalPrice = pricePerKg.multiply(BigDecimal.valueOf(weight));
        return strategy != null ? strategy.calculate(originalPrice) : originalPrice;
    }
}