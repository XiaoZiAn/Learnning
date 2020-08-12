package com.xx.designpattern.BehaviorPattern.TemplateMethod;

/**
 * @author xiaoxinga
 * @date 2020/06/08 11:49
 * @since
 */
public class CookBeanSprout extends CookVegetable {
    @Override
    protected void pourOil() {
        System.out.println("热锅少油");
    }

    @Override
    protected void fry() {
        System.out.println("快速翻炒");
    }

    @Override
    protected void pourSauce() {
        System.out.println("加盐和少量生抽");
    }
}
