package com.guangyi.service;

import java.math.BigDecimal;

import com.guangyi.constant.PriceConstant;
import com.guangyi.factory.FruitFactory;
import com.guangyi.model.ShoppingCart;
import com.guangyi.model.impl.ShoppingCartImpl;
import com.guangyi.strategy.impl.FullReductionStrategy;
import com.guangyi.strategy.impl.OriginalPriceStrategy;
import com.guangyi.strategy.impl.StrawberryDiscountStrategy;

/**
 * 购物服务类，提供各种购物计算服务
 */
public class ShoppingService {

    /**
     * 计算顾客购买苹果和草莓的总价（原价）
     *
     * @param appleWeight      苹果重量（斤）
     * @param strawberryWeight 草莓重量（斤）
     * @return 总价
     */
    public BigDecimal calculateTotalWithAppleAndStrawberry(int appleWeight, int strawberryWeight) {
        ShoppingCart cart = new ShoppingCartImpl();
        cart.addFruit(FruitFactory.createApple(appleWeight));
        cart.addFruit(FruitFactory.createStrawberry(strawberryWeight));
        return cart.calculateTotal(new OriginalPriceStrategy());
    }

    /**
     * 计算顾客购买苹果、草莓和芒果的总价（原价）
     *
     * @param appleWeight      苹果重量（斤）
     * @param strawberryWeight 草莓重量（斤）
     * @param mangoWeight      芒果重量（斤）
     * @return 总价
     */
    public BigDecimal calculateTotalWithThreeFruits(int appleWeight, int strawberryWeight, int mangoWeight) {
        ShoppingCart cart = new ShoppingCartImpl();
        cart.addFruit(FruitFactory.createApple(appleWeight));
        cart.addFruit(FruitFactory.createStrawberry(strawberryWeight));
        cart.addFruit(FruitFactory.createMango(mangoWeight));
        return cart.calculateTotal(new OriginalPriceStrategy());
    }

    /**
     * 计算顾客购买三种水果的总价（草莓8折）
     *
     * @param appleWeight      苹果重量（斤）
     * @param strawberryWeight 草莓重量（斤）
     * @param mangoWeight      芒果重量（斤）
     * @return 总价
     */
    public BigDecimal calculateTotalWithStrawberryDiscount(int appleWeight, int strawberryWeight, int mangoWeight) {
        ShoppingCart cart = new ShoppingCartImpl();
        cart.addFruit(FruitFactory.createApple(appleWeight));
        cart.addFruit(FruitFactory.createStrawberry(strawberryWeight));
        cart.addFruit(FruitFactory.createMango(mangoWeight));
        return cart.calculateTotal(new StrawberryDiscountStrategy(), new OriginalPriceStrategy());
    }

    /**
     * 计算顾客购买三种水果的总价（草莓8折，满100减10）
     *
     * @param appleWeight      苹果重量（斤）
     * @param strawberryWeight 草莓重量（斤）
     * @param mangoWeight      芒果重量（斤）
     * @return 总价
     */
    public BigDecimal calculateTotalWithDiscountAndReduction(int appleWeight, int strawberryWeight, int mangoWeight) {
        ShoppingCart cart = new ShoppingCartImpl();
        cart.addFruit(FruitFactory.createApple(appleWeight));
        cart.addFruit(FruitFactory.createStrawberry(strawberryWeight));
        cart.addFruit(FruitFactory.createMango(mangoWeight));
        return cart.calculateTotal(
                new StrawberryDiscountStrategy(),
                new OriginalPriceStrategy(),
                new FullReductionStrategy(PriceConstant.FULL_REDUCTION_THRESHOLD, PriceConstant.FULL_REDUCTION_AMOUNT)
        );
    }
}