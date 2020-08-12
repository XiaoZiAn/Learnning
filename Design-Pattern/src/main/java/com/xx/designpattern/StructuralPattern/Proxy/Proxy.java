package com.xx.designpattern.StructuralPattern.Proxy;

import com.xx.designpattern.StructuralPattern.Decorator.Source;
import com.xx.designpattern.StructuralPattern.Decorator.Sourceable;

/**
 * 代理模式
 *
 * @author xiaoxinga
 * @date 2020/06/08 10:20
 * @since
 */
public class Proxy implements Sourceable {
    private Source source;

    public Proxy() {
        super();
        this.source = new Source();
    }

    @Override
    public void method() {
        before();
        source.method();
        atfer();
    }

    private void atfer() {
        System.out.println("after proxy!");
    }

    private void before() {
        System.out.println("before proxy!");
    }

    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }
}
