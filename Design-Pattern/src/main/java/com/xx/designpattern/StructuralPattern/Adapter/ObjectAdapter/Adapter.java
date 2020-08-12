package com.xx.designpattern.StructuralPattern.Adapter.ObjectAdapter;

import com.xx.designpattern.StructuralPattern.Adapter.ClassAdapter.Adaptee;
import com.xx.designpattern.StructuralPattern.Adapter.ClassAdapter.ConcreteTarget;
import com.xx.designpattern.StructuralPattern.Adapter.ClassAdapter.Target;

/**
 * 对象适配器模式
 *
 * @author xiaoxinga
 * @date 2020/06/08 9:17
 * @since
 */
public class Adapter implements Target {

    // 适配者是对象适配器的一个属性
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        //...
        adaptee.adapteeRequest();
        //...
    }

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new com.xx.designpattern.StructuralPattern.Adapter.ClassAdapter.Adapter();
        adapterTarget.request();
    }
}
