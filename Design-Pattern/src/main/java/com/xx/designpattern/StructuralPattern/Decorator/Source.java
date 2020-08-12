package com.xx.designpattern.StructuralPattern.Decorator;

/**
 * @author xiaoxinga
 * @date 2020/06/08 10:15
 * @since
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}
