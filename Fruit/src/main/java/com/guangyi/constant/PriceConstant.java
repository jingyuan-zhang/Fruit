package com.guangyi.constant;

/**
 * 价格常量类，存储所有水果单价和促销相关常量
 */
public class PriceConstant {
    // 水果单价（元/斤）
    public static final double APPLE_PRICE_PER_KG = 8.0;
    public static final double STRAWBERRY_PRICE_PER_KG = 13.0;
    public static final double MANGO_PRICE_PER_KG = 20.0;

    // 促销常量
    public static final double STRAWBERRY_DISCOUNT_RATE = 0.8; // 草莓8折
    public static final double FULL_REDUCTION_THRESHOLD = 100.0; // 满100
    public static final double FULL_REDUCTION_AMOUNT = 10.0; // 减10
}