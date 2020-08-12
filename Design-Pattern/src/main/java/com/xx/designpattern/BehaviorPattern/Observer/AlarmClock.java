package com.xx.designpattern.BehaviorPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoxinga
 * @date 2020/06/08 14:04
 * @since
 */
public class AlarmClock implements Observable {
    private List<Observer> observers = new ArrayList<Observer>();

    @Override
    public boolean register(Observer observer) {
        return !this.observers.contains(observer) && this.observers.add(observer);
    }

    @Override
    public boolean unRegister(Observer observer) {
        return this.observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        System.out.println("Time out!");
        for (Observer observer : this.observers) {
            observer.update();
        }
    }
}
