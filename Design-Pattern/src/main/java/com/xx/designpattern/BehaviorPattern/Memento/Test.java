package com.xx.designpattern.BehaviorPattern.Memento;

/**
 * 备忘录模式
 *
 * @author xiaoxinga
 * @date 2020/06/08 16:02
 * @since
 */
public class Test {
    public static void main(String[] args) {
        GameCaretaker caretaker = new GameCaretaker();
        // 初始化到第一关
        Game game = new Game();
        System.out.println(game);
        // 第一关通过，存档
        caretaker.addSnapshot(game.createGameInfo());

        // 进入第二关
        game.doneChapter("002");
        System.out.println(game);
        // 第二关通过，存档
        caretaker.addSnapshot(game.createGameInfo());

        // 进入第三关
        game.doneChapter("003");
        System.out.println(game);
        // 第三关通过，存档
        caretaker.addSnapshot(game.createGameInfo());

        // 返回第二关
        game.restore(caretaker.getSnapshot("002"));
        System.out.println("rollback to chapter 002");
        System.out.println(game);
    }
}
