package com.xx.designpattern.BehaviorPattern.Memento;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoxinga
 * @date 2020/06/08 15:46
 * @since
 */
public class GameCaretaker {
    private Map<String, GameInfo> mGameSnapshots = new HashMap<String, GameInfo>();

    public void addSnapshot(GameInfo snapshot) {
        this.mGameSnapshots.put(snapshot.name(), snapshot);
    }

    public GameInfo getSnapshot(String name) {
        return this.mGameSnapshots.getOrDefault(name, null);
    }
}
