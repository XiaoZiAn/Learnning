package com.xx.designpattern.BehaviorPattern.ChainOfResponsibility;

/**
 * 责任链模式
 *
 * @author xiaoxinga
 * @date 2020/06/08 14:52
 * @since
 */
public class Test {
    // ConcreteHandlerA处理者不感兴趣，ConcreteHandlerB处理该消息
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setnextHanlder(handlerB);
        handlerA.handleRequest("requestB");
    }
}
