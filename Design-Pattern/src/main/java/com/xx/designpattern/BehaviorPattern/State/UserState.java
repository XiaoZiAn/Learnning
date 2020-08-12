package com.xx.designpattern.BehaviorPattern.State;

/**
 * @author xiaoxinga
 * @date 2020/06/08 17:07
 * @since
 */
public abstract class UserState {
    protected AppContext mContext;

    public void setContext(AppContext context) {
        this.mContext = context;
    }

    public abstract void favorite();

    public abstract void comment(String comment);
}
