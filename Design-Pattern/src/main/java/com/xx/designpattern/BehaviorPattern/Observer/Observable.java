package com.xx.designpattern.BehaviorPattern.Observer;

/**
 * @author xiaoxinga
 * @date 2020/06/08 14:01
 * @since
 */
public interface Observable {
    boolean register(Observer observer);

    boolean unRegister(Observer observer);

    void notifyObserver();
}
