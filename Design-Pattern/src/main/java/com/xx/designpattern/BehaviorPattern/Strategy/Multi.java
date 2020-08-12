package com.xx.designpattern.BehaviorPattern.Strategy;

/**
 * @author xiaoxinga
 * @date 2020/06/08 11:31
 * @since
 */
public class Multi implements ICalculator {
    @Override
    public int calc(int a, int b) {
        return a * b;
    }
}
