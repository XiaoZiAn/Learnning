package com.xx.designpattern.BehaviorPattern.State;

/**
 * @author xiaoxinga
 * @date 2020/06/08 17:08
 * @since
 */
public class LoginOutState extends UserState {
    @Override
    public void favorite() {
        this.switch2Login();
        this.mContext.getState().favorite();
    }

    @Override
    public void comment(String comment) {
        this.switch2Login();
        this.mContext.getState().comment(comment);
    }

    private void switch2Login() {
        System.out.println("jump to login interface!");
        this.mContext.setState(this.mContext.STATE_LOGIN_IN);
    }
}
