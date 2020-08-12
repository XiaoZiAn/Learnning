package com.xx.designpattern.BehaviorPattern.Visitor;

/**
 * @author xiaoxinga
 * @date 2020/06/09 9:21
 * @since
 */
public interface Viewer {
    void show(PlayerA player);

    void show(PlayerB player);
}
