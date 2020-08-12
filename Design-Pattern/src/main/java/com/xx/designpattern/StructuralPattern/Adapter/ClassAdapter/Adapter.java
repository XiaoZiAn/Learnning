package com.xx.designpattern.StructuralPattern.Adapter.ClassAdapter;

/**
 * 类适配器模式
 *
 * @author xiaoxinga
 * @date 2020/06/08 9:14
 * @since
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        //...一些操作...
        super.adapteeRequest();
        //...一些操作...
    }

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }
}
