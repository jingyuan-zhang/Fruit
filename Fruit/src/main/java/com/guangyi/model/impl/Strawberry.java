package com.guangyi.model.impl;

import com.guangyi.constant.PriceConstant;
import com.guangyi.model.AbstractFruit;

/**
 * 草莓
 */
public class Strawberry extends AbstractFruit {
    /**
     * 构造方法
     *
     * @param weight 重量（斤）
     */
    public Strawberry(int weight) {
        super("strawberry", PriceConstant.STRAWBERRY_PRICE_PER_KG, weight);
    }
}