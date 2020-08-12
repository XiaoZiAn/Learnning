package com.xx.designpattern.BehaviorPattern.Visitor;

/**
 * @author xiaoxinga
 * @date 2020/06/09 10:16
 * @since
 */
public class BossViewer implements Viewer {
    @Override
    public void show(PlayerA player) {
        this.getInterested(player);
    }

    @Override
    public void show(PlayerB player) {
        this.getInterested(player);
    }

    private void getInterested(Player player) {
        String name = player.getName();
        int salary = player.getSalary();
        int fans = player.getFans();
        System.out.println(name + " [salary: $" + salary + " ,fans: " + fans + "]");
    }
}
