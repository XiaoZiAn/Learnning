package com.xx.designpattern.BehaviorPattern.TemplateMethod;

/**
 * @author xiaoxinga
 * @date 2020/06/08 11:49
 * @since
 */
public class CookEggplant extends CookVegetable {

    @Override
    protected void wash() {
        System.out.println("去除头尾，然后用水洗下");
    }

    @Override
    protected void pourOil() {
        System.out.println("热锅多油");
    }

    @Override
    protected void pourSauce() {
        System.out.println("加盐和鸡精");
    }
}
