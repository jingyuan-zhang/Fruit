package com.guangyi.model.impl;

import com.guangyi.constant.PriceConstant;
import com.guangyi.model.AbstractFruit;

/**
 * 芒果
 */
public class Mango extends AbstractFruit {
    /**
     * 构造方法
     *
     * @param weight 重量（斤）
     */
    public Mango(int weight) {
        super("mango", PriceConstant.MANGO_PRICE_PER_KG, weight);
    }
}