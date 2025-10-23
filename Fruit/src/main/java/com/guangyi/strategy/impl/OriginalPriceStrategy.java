package com.guangyi.strategy.impl;

import com.guangyi.strategy.PricingStrategy;

import java.math.BigDecimal;

/**
 * 原价策略
 */
public class OriginalPriceStrategy implements PricingStrategy {
    @Override
    public BigDecimal calculate(BigDecimal originalPrice) {
        return originalPrice;
    }
}