package com.xx.designpattern.BehaviorPattern.Memento;

/**
 * @author xiaoxinga
 * @date 2020/06/08 15:53
 * @since
 */
public class Game {
    // 关卡时间
    private String name;

    public Game() {
        this.name = "001";
    }

    public Game(String name) {
        this.name = name;
    }

    public void doneChapter(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public GameInfo createGameInfo() {
        return new GameInfoMemento(this.name);
    }

    public void restore(GameInfo info) {
        if (info == null) {
            throw new IllegalArgumentException("Game Snapshot is empty!!");
        }
        GameInfoMemento game = (GameInfoMemento) info;
        this.name = game.name();
    }

    @Override
    public String toString() {
        return "Game[" + this.name + "]";
    }
}
