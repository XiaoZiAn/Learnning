package com.xx.designpattern.StructuralPattern.Adapter;

/**
 * @author xiaoxinga
 * @date 2020/06/08 9:24
 * @since
 */
public class JapanPowerAdapter implements DC5Adapter {
    public static final int voltage = 110;

    @Override
    public boolean support(AC ac) {
        return (voltage == ac.outPut());
    }

    @Override
    public int outputDC5V(AC ac) {
        int adapterInput = ac.outPut();
        //变压器...
        int adapterOutput = adapterInput / 22;
        System.out.println("使用JapanPowerAdapter变压适配器，输入AC:" + adapterInput + "V" + "，输出DC:" + adapterOutput + "V");
        return adapterOutput;
    }
}
