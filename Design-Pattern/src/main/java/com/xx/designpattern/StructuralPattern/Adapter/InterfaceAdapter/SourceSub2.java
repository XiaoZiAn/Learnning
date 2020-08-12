package com.xx.designpattern.StructuralPattern.Adapter.InterfaceAdapter;

/**
 * @author xiaoxinga
 * @date 2020/06/08 10:02
 * @since
 */
public class SourceSub2 extends Wrapper {
    public void method2() {
        System.out.println("the sourceable interface's second Sub2!");
    }

    public static void main(String[] args) {
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();

        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }
}
