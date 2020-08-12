package com.xx.designpattern.BehaviorPattern.Interpreter;

import java.util.Stack;

/**
 * 解释器模式
 *
 * @author xiaoxinga
 * @date 2020/06/09 14:25
 * @since
 */
public class Calculator {
    private Stack<ArithmeticExpression> stack = new Stack<>();

    public Calculator(String expression) {
        this.analyse(expression);
    }

    private void analyse(String expression) {
        String[] elements = expression.split(" ");
        ArithmeticExpression leftExpr, rightExpr;
        for (int i = 0, len = elements.length; i < len; ++i) {
            switch (elements[i]) {
                case "+":
                    leftExpr = this.stack.pop();
                    rightExpr = new NumExpression(Integer.valueOf(elements[++i]));
                    this.stack.push(new AddExpression(leftExpr, rightExpr));
                    break;
                case "-":
                    leftExpr = this.stack.pop();
                    rightExpr = new NumExpression(Integer.valueOf(elements[++i]));
                    this.stack.push(new SubtractionExpression(leftExpr, rightExpr));
                    break;
                default:
                    this.stack.push(new NumExpression(Integer.valueOf(elements[i])));
                    break;
            }
        }
    }

    public int calculate() {
        return this.stack.pop().interpret();
    }

    public static void main(String[] args) {
        System.out.println("result: " + new Calculator("10 + 30").calculate());
        System.out.println("result: " + new Calculator("10 + 30 - 20").calculate());
        System.out.println("result: " + new Calculator("10 + 30 - 20 + 15").calculate());
    }
}
