package com.xx.designpattern.BehaviorPattern.Observer;

/**
 * 观察者模式
 *
 * @author xiaoxinga
 * @date 2020/06/08 13:52
 * @since
 */
public class Me implements Observer {
    @Override
    public void update() {
        System.out.println("I have to get up!");
    }

    public static void main(String[] args) {
        //来一个闹钟
        Observable alarmClock = new AlarmClock();
        //我
        Observer me = new Me();
        //设置闹钟时间（注册监听）
        alarmClock.register(me);
        //闹钟响铃
        alarmClock.notifyObserver();
    }
}
