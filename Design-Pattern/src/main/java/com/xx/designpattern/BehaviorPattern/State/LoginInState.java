package com.xx.designpattern.BehaviorPattern.State;

/**
 * @author xiaoxinga
 * @date 2020/06/08 17:07
 * @since
 */
public class LoginInState extends UserState {
    @Override
    public void favorite() {
        System.out.println("favorite: save it");
    }

    @Override
    public void comment(String comment) {
        System.out.println(comment);
    }
}
