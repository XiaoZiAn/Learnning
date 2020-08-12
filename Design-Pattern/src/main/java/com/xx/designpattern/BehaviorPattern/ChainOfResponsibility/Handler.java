package com.xx.designpattern.BehaviorPattern.ChainOfResponsibility;

/**
 * @author xiaoxinga
 * @date 2020/06/08 14:50
 * @since
 */
public abstract class Handler {
    protected Handler mNextHandler;

    public void setnextHanlder(Handler successor) {
        this.mNextHandler = successor;
    }

    public abstract void handleRequest(String request);
}
