package com.xx.designpattern.BehaviorPattern.Strategy;

/**
 * 策略模式
 *
 * @author xiaoxinga
 * @date 2020/06/08 11:33
 * @since
 */
public class CalcContext {
    private ICalculator mCalculator;

    public CalcContext(ICalculator calculator) {
        this.mCalculator = calculator;
    }

    public int calc(int a, int b) {
        return this.mCalculator.calc(a, b);
    }

    public static void main(String[] args) {
        CalcContext calcContext = new CalcContext(new Add());
        int a = calcContext.calc(1, 2);
        System.out.println(a);
    }
}
