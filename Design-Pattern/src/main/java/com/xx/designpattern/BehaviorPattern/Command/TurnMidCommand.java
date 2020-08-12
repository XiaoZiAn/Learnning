package com.xx.designpattern.BehaviorPattern.Command;

/**
 * @author xiaoxinga
 * @date 2020/06/08 15:02
 * @since
 */
public class TurnMidCommand implements Command {
    private Fan mFan;

    public TurnMidCommand(Fan fan) {
        this.mFan = fan;
    }

    @Override
    public void exe() {
        this.mFan.turnMid();
    }
}
