package com.xx.designpattern.BehaviorPattern.Visitor;

import java.util.Arrays;
import java.util.List;

/**
 * 访问者模式
 *
 * @author xiaoxinga
 * @date 2020/06/09 10:17
 * @since
 */
public class Manager {
    private List<? extends Player> mPlayers = Arrays.asList(
            new PlayerA("John", "good", 20, 500000, 2000000),
            new PlayerA("Bill", "excellent", 30, 15000000, 20000000));

    public void show(Viewer viewer) {
        for (Player player : this.mPlayers) {
            player.accept(viewer);
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager();

        System.out.println("Coach look up:");
        Viewer coach = new CoachViewer();
        manager.show(coach);

        System.out.println("--------------------");
        System.out.println("Boss look up:");
        Viewer boss = new BossViewer();
        manager.show(boss);

    }
}
