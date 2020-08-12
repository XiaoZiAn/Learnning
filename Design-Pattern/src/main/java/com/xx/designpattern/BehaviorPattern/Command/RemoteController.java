package com.xx.designpattern.BehaviorPattern.Command;

/**
 * 命令模式
 *
 * @author xiaoxinga
 * @date 2020/06/08 15:05
 * @since
 */
public class RemoteController {
    public void action(Command cmd) {
        cmd.exe();
    }

    public static void main(String[] args) {
        RemoteController remote = new RemoteController();
        Fan fan = new Fan();

        Command cmd = new TurnMinCommand(fan);
        remote.action(cmd);

        cmd = new TurnMidCommand(fan);
        remote.action(cmd);

        cmd = new TurnMaxCommand(fan);
        remote.action(cmd);

        cmd = new TurnOffCommand(fan);
        remote.action(cmd);
    }
}
