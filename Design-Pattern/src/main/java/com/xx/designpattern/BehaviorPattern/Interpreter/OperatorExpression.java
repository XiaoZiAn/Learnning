package com.xx.designpattern.BehaviorPattern.Interpreter;

/**
 * 非终结符表达式
 *
 * @author xiaoxinga
 * @date 2020/06/09 14:22
 * @since
 */
public abstract class OperatorExpression implements ArithmeticExpression {
    protected ArithmeticExpression left;
    protected ArithmeticExpression right;

    public OperatorExpression(ArithmeticExpression left, ArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }
}
