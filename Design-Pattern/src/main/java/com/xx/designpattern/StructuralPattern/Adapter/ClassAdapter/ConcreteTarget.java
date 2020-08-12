package com.xx.designpattern.StructuralPattern.Adapter.ClassAdapter;

/**
 * @author xiaoxinga
 * @date 2020/06/08 9:13
 * @since
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}
