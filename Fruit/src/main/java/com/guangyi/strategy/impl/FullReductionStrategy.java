package com.guangyi.strategy.impl;

import com.guangyi.strategy.GlobalPricingStrategy;

import java.math.BigDecimal;

/**
 * 满减策略
 */
public class FullReductionStrategy implements GlobalPricingStrategy {
    private final BigDecimal threshold;
    private final BigDecimal reduction;

    /**
     * 构造方法
     *
     * @param threshold 满减门槛
     * @param reduction 减免金额
     */
    public FullReductionStrategy(double threshold, double reduction) {
        this.threshold = BigDecimal.valueOf(threshold);
        this.reduction = BigDecimal.valueOf(reduction);
    }

    @Override
    public BigDecimal calculate(BigDecimal originalPrice) {
        return originalPrice.compareTo(threshold) >= 0
                ? originalPrice.subtract(reduction)
                : originalPrice;
    }
}