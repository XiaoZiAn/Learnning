package com.xx.designpattern.BehaviorPattern.Visitor;

/**
 * @author xiaoxinga
 * @date 2020/06/09 9:19
 * @since
 */
public abstract class Player {
    // 姓名
    private String name;
    // 身体素质
    private String fitness;
    // 场均得分
    private int scorePerGame;
    // 粉丝数量
    private int fans;
    // 身价
    private int salary;

    public Player(String name, String fitness, int scorePerGame, int fans, int salary) {
        this.name = name;
        this.fitness = fitness;
        this.scorePerGame = scorePerGame;
        this.fans = fans;
        this.salary = salary;
    }

    abstract void accept(Viewer viewer);

    public String getName() {
        return name;
    }

    public String getFitness() {
        return fitness;
    }

    public int getScorePerGame() {
        return scorePerGame;
    }

    public int getFans() {
        return fans;
    }

    public int getSalary() {
        return salary;
    }
}
