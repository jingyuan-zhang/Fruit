package com.guangyi.strategy;

import java.math.BigDecimal;

/**
 * 价格计算策略接口
 */
public interface PricingStrategy {
    /**
     * 计算价格
     *
     * @param originalPrice 原始价格
     * @return 计算后价格
     */
    BigDecimal calculate(BigDecimal originalPrice);
}