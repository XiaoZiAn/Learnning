package com.xx.designpattern.BehaviorPattern.Command;

/**
 * @author xiaoxinga
 * @date 2020/06/08 15:01
 * @since
 */
public class Fan {
    public void turnMin() {
        System.out.println("Fan in Min degree");
    }

    public void turnMid() {
        System.out.println("Fan in Mid degree");
    }

    public void turnMax() {
        System.out.println("Fan in Max degree");
    }

    public void turnOff() {
        System.out.println("Fan off");
    }
}
