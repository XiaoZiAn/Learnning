package com.xx.designpattern.BehaviorPattern.Visitor;

/**
 * @author xiaoxinga
 * @date 2020/06/09 10:13
 * @since
 */
public class CoachViewer implements Viewer {
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
        String fitness = player.getFitness();
        int scorePerGame = player.getScorePerGame();
        System.out.println(name + " [body: " + fitness + ",scorePerGame: " + scorePerGame + "]");
    }
}
