package com.xx.designpattern.BehaviorPattern.Visitor;

/**
 * @author xiaoxinga
 * @date 2020/06/09 10:06
 * @since
 */
public class PlayerB extends Player {
    public PlayerB(String name, String fitness, int scorePerGame, int fans, int salary) {
        super(name, fitness, scorePerGame, fans, salary);
    }

    @Override
    void accept(Viewer viewer) {
        viewer.show(this);
    }
}
