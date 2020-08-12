package com.xx.designpattern.StructuralPattern.Adapter;

/**
 * @author xiaoxinga
 * @date 2020/06/08 9:22
 * @since
 */
public interface DC5Adapter {
    boolean support(AC ac);

    int outputDC5V(AC ac);
}
