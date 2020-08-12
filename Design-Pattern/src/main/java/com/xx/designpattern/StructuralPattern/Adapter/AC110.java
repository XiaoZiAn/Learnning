package com.xx.designpattern.StructuralPattern.Adapter;

/**
 * @author xiaoxinga
 * @date 2020/06/08 9:20
 * @since
 */
public class AC110 implements AC {
    public final int output = 110;

    @Override
    public int outPut() {
        return output;
    }
}
