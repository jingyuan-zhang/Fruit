package com.guangyi.model;

import java.math.BigDecimal;

import com.guangyi.strategy.PricingStrategy;

/**
 * 购物车接口
 */
public interface ShoppingCart {
    /**
     * 添加水果到购物车
     *
     * @param fruit 水果
     */
    void addFruit(Fruit fruit);

    /**
     * 计算购物车总价
     *
     * @param strategies 价格计算策略
     * @return 购物车总价
     */
    BigDecimal calculateTotal(PricingStrategy... strategies);
}