package com.xx.designpattern.BehaviorPattern.TemplateMethod;

/**
 * @author xiaoxinga
 * @date 2020/06/08 11:50
 * @since
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("准备炒豆芽");
        CookVegetable cookVegetable = new CookBeanSprout();
        cookVegetable.cook();

        System.out.println();
        System.out.println("准备炒茄子");
        cookVegetable = new CookEggplant();
        cookVegetable.cook();
    }
}
