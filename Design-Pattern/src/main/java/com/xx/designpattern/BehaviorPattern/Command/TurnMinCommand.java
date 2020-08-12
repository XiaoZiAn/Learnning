package com.xx.designpattern.BehaviorPattern.Command;

/**
 * @author xiaoxinga
 * @date 2020/06/08 15:01
 * @since
 */
public class TurnMinCommand implements Command {
    private Fan mFan;

    public TurnMinCommand(Fan fan) {
        this.mFan = fan;
    }

    @Override
    public void exe() {
        this.mFan.turnMin();
    }
}
