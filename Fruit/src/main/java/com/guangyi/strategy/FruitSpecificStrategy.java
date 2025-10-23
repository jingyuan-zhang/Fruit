package com.guangyi.strategy;

import com.guangyi.model.Fruit;

/**
 * 水果特定折扣策略接口
 */
public interface FruitSpecificStrategy extends PricingStrategy {
    /**
     * 判断策略是否适用于指定水果
     *
     * @param fruit 水果
     * @return 是否适用
     */
    boolean isApplicable(Fruit fruit);
}