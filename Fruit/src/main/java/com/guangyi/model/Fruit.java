package com.guangyi.model;

import java.math.BigDecimal;

import com.guangyi.strategy.PricingStrategy;

/**
 * 水果接口
 */
public interface Fruit {
    /**
     * 获取水果名称
     *
     * @return 水果名称
     */
    String getName();

    /**
     * 获取单价
     *
     * @return 单价（元/斤）
     */
    BigDecimal getPricePerKg();

    /**
     * 获取重量
     *
     * @return 重量（斤）
     */
    int getWeight();

    /**
     * 计算水果价格
     *
     * @param strategy 价格计算策略
     * @return 水果总价
     */
    BigDecimal calculatePrice(PricingStrategy strategy);
}