package com.guangyi.model.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.guangyi.model.Fruit;
import com.guangyi.model.ShoppingCart;
import com.guangyi.strategy.FruitSpecificStrategy;
import com.guangyi.strategy.GlobalPricingStrategy;
import com.guangyi.strategy.impl.OriginalPriceStrategy;
import com.guangyi.strategy.PricingStrategy;

/**
 * 购物车实现类
 */
public class ShoppingCartImpl implements ShoppingCart {
    private final List<Fruit> fruits = new ArrayList<>();

    @Override
    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    @Override
    public BigDecimal calculateTotal(PricingStrategy... strategies) {
        BigDecimal total = BigDecimal.ZERO;

        // 计算每种水果的价格
        for (Fruit fruit : fruits) {
            // 找到适用于当前水果的策略
            PricingStrategy applicableStrategy = findApplicableStrategy(fruit, strategies);
            total = total.add(fruit.calculatePrice(applicableStrategy));
        }

        // 应用全局策略（如满减）
        for (PricingStrategy strategy : strategies) {
            if (strategy instanceof GlobalPricingStrategy) {
                total = strategy.calculate(total);
            }
        }

        // 保留两位小数，四舍五入
        return total.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 查找适用于指定水果的策略
     *
     * @param fruit      水果
     * @param strategies 策略数组
     * @return 适用的策略
     */
    private PricingStrategy findApplicableStrategy(Fruit fruit, PricingStrategy[] strategies) {
        if (strategies == null || strategies.length == 0) {
            return new OriginalPriceStrategy();
        }

        for (PricingStrategy strategy : strategies) {
            if (strategy instanceof FruitSpecificStrategy &&
                    ((FruitSpecificStrategy) strategy).isApplicable(fruit)) {
                return strategy;
            }
        }

        // 如果没有找到特定策略，使用默认策略
        return new OriginalPriceStrategy();
    }
}