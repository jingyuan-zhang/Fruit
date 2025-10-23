package com.guangyi.factory;


import com.guangyi.model.Fruit;
import com.guangyi.model.AbstractFruit;
import com.guangyi.model.impl.Apple;
import com.guangyi.model.impl.Mango;
import com.guangyi.model.impl.Strawberry;

/**
 * 水果工厂类
 */
public class FruitFactory {
    /**
     * 创建苹果
     *
     * @param weight 重量（斤）
     * @return 苹果实例
     */
    public static Fruit createApple(int weight) {
        return new Apple(weight);
    }

    /**
     * 创建草莓
     *
     * @param weight 重量（斤）
     * @return 草莓实例
     */
    public static Fruit createStrawberry(int weight) {
        return new Strawberry(weight);
    }

    /**
     * 创建芒果
     *
     * @param weight 重量（斤）
     * @return 芒果实例
     */
    public static Fruit createMango(int weight) {
        return new Mango(weight);
    }

    /**
     * 创建自定义水果
     *
     * @param name       水果名称
     * @param pricePerKg 单价（元/斤）
     * @param weight     重量（斤）
     * @return 自定义水果实例
     */
    public static Fruit createFruit(String name, double pricePerKg, int weight) {
        return new AbstractFruit(name, pricePerKg, weight) {
        };
    }
}