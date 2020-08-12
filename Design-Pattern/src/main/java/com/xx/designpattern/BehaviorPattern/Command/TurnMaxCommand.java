package com.xx.designpattern.BehaviorPattern.Command;

/**
 * @author xiaoxinga
 * @date 2020/06/08 15:03
 * @since
 */
public class TurnMaxCommand implements Command {
    private Fan mFan;

    public TurnMaxCommand(Fan fan) {
        this.mFan = fan;
    }

    @Override
    public void exe() {
        this.mFan.turnMax();
    }
}
