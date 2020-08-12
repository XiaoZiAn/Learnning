package com.xx.designpattern.BehaviorPattern.ChainOfResponsibility;

/**
 * @author xiaoxinga
 * @date 2020/06/08 14:51
 * @since
 */
public class ConcreteHandlerB extends Handler {

    @Override
    public void handleRequest(String request) {
        if ("requestB".equals(request)) {
            System.out.println(String.format("%s deal with request: %s", this.getClass().getSimpleName(), request));
            return;
        }
        if (this.mNextHandler != null) {
            this.mNextHandler.handleRequest(request);
        }
    }
}
