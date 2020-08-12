package com.xx.designpattern.BehaviorPattern.Interpreter;

/**
 * 终结符表达式
 *
 * @author xiaoxinga
 * @date 2020/06/09 14:21
 * @since
 */
public class NumExpression implements ArithmeticExpression {
    private int value;

    public NumExpression(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return this.value;
    }
}
