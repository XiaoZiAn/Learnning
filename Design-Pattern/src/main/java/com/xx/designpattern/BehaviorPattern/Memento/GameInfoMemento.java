package com.xx.designpattern.BehaviorPattern.Memento;

/**
 * @author xiaoxinga
 * @date 2020/06/08 15:40
 * @since
 */
public class GameInfoMemento implements GameInfo {
    // 关卡级别
    private String name;

    GameInfoMemento(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }
}
