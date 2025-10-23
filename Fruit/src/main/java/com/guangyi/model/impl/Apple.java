package com.guangyi.model.impl;

import com.guangyi.constant.PriceConstant;
import com.guangyi.model.AbstractFruit;

/**
 * 苹果
 */
public class Apple extends AbstractFruit {
    /**
     * 构造方法
     *
     * @param weight 重量（斤）
     */
    public Apple(int weight) {
        super("apple", PriceConstant.APPLE_PRICE_PER_KG, weight);
    }
}