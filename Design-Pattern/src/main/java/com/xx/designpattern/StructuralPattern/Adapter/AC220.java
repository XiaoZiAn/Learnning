package com.xx.designpattern.StructuralPattern.Adapter;

/**
 * @author xiaoxinga
 * @date 2020/06/08 9:21
 * @since
 */
public class AC220 implements AC {
    public final int output = 220;

    @Override
    public int outPut() {
        return output;
    }
}
