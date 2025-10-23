package com.guangyi.test;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import com.guangyi.factory.FruitFactory;
import com.guangyi.model.Fruit;
import com.guangyi.model.ShoppingCart;
import com.guangyi.service.ShoppingService;
import com.guangyi.model.impl.ShoppingCartImpl;
import com.guangyi.strategy.impl.OriginalPriceStrategy;
import com.guangyi.strategy.impl.SpecificFruitDiscountStrategy;


/**
 * 购物服务测试类
 */
@Slf4j
public class ShoppingServiceTest {
    private final ShoppingService service = new ShoppingService();

    /**
     * 测试只购买苹果和草莓的情况
     */
    @Test
    public void testCalculateTotalWithAppleAndStrawberry() {
        // 正例：正常购买
        Assert.assertEquals(
                new BigDecimal("55.00"),
                service.calculateTotalWithAppleAndStrawberry(2, 3)
        );

        // 边界值：购买0斤
        Assert.assertEquals(
                BigDecimal.ZERO.setScale(2),
                service.calculateTotalWithAppleAndStrawberry(0, 0)
        );

        // 边界值：只买一种水果
        Assert.assertEquals(
                new BigDecimal("40.00"),
                service.calculateTotalWithAppleAndStrawberry(5, 0)
        );
        log.info("测试只购买苹果和草莓的情况");
    }

    /**
     * 测试购买三种水果的情况（原价）
     */
    @Test
    public void testCalculateTotalWithThreeFruits() {
        // 正例：正常购买
        Assert.assertEquals(
                new BigDecimal("75.00"),
                service.calculateTotalWithThreeFruits(2, 3, 1)
        );

        // 边界值：购买0斤
        Assert.assertEquals(
                BigDecimal.ZERO.setScale(2),
                service.calculateTotalWithThreeFruits(0, 0, 0)
        );
        log.info("测试购买三种水果的情况（原价）");
    }

    /**
     * 测试草莓打折的情况
     */
    @Test
    public void testCalculateTotalWithStrawberryDiscount() {
        // 正例：正常购买
        Assert.assertEquals(
                new BigDecimal("67.20"),
                service.calculateTotalWithStrawberryDiscount(2, 3, 1)
        );

        // 边界值：草莓0斤
        Assert.assertEquals(
                new BigDecimal("56.00"),
                service.calculateTotalWithStrawberryDiscount(2, 0, 2)
        );
        log.info("测试草莓打折的情况");
    }

    /**
     * 测试草莓打折且满减的情况
     */
    @Test
    public void testCalculateTotalWithDiscountAndReduction() {
        // 正例：不满足满减
        Assert.assertEquals(
                new BigDecimal("67.20"),
                service.calculateTotalWithDiscountAndReduction(2, 3, 1)
        );

        // 边界值：刚好满足满减条件（100元）
        Assert.assertEquals(
                new BigDecimal("90.00"),
                service.calculateTotalWithDiscountAndReduction(0, 0, 5)
        );

        // 边界值：刚好超过满减条件（120元）
        Assert.assertEquals(
                new BigDecimal("110.00"),
                service.calculateTotalWithDiscountAndReduction(0, 0, 6)
        );

        // 边界值：刚好不满足满减条件（96元）
        Assert.assertEquals(
                new BigDecimal("96.00"),
                service.calculateTotalWithDiscountAndReduction(12, 0, 0)
        );

        // 正例：满足满减条件
        Assert.assertEquals(
                new BigDecimal("142.00"),
                service.calculateTotalWithDiscountAndReduction(5, 5, 3)
        );
        log.info("测试草莓打折且满减的情况");
    }

    /**
     * 测试扩展性：新增水果和更换打折水果
     */
    @Test
    public void testExtensibility() {
        // 测试新增水果（橙子）
        Fruit orange = FruitFactory.createFruit("orange", 15.0, 2);

        // 测试更换打折水果（芒果打9折）
        ShoppingCart cart = new ShoppingCartImpl();
        cart.addFruit(FruitFactory.createApple(2));  // 2*8=16
        cart.addFruit(FruitFactory.createMango(3));  // 3*20*0.9=54
        cart.addFruit(orange);                       // 2*15=30
        // 总计：16+54+30=100

        BigDecimal total = cart.calculateTotal(
                new SpecificFruitDiscountStrategy("mango", 0.9),
                new OriginalPriceStrategy()
        );

        Assert.assertEquals(new BigDecimal("100.00"), total);
        log.info("测试扩展性：新增水果和更换打折水果");
    }
}