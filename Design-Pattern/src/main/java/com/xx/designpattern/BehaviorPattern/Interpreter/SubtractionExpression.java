package com.xx.designpattern.BehaviorPattern.Interpreter;

/**
 * @author xiaoxinga
 * @date 2020/06/09 14:24
 * @since
 */
public class SubtractionExpression extends OperatorExpression {
    public SubtractionExpression(ArithmeticExpression left, ArithmeticExpression right) {
        super(left, right);
    }

    @Override
    public int interpret() {
        return this.left.interpret() - this.right.interpret();
    }
}
