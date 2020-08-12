package com.xx.designpattern.BehaviorPattern.Command;

/**
 * @author xiaoxinga
 * @date 2020/06/08 15:04
 * @since
 */
public class TurnOffCommand implements Command {
        private Fan mFan;

        public TurnOffCommand(Fan fan) {
            this.mFan = fan;
        }

        @Override
        public void exe() {
            this.mFan.turnOff();
        }
}
