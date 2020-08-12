package com.xx.designpattern.BehaviorPattern.State;

/**
 * @author xiaoxinga
 * @date 2020/06/08 17:06
 * @since
 */
public class AppContext {
    public static final UserState STATE_LOGIN_IN = new LoginInState();
    public static final UserState STATE_LOGIN_OUT = new LoginOutState();
    private UserState mCurrentState = STATE_LOGIN_OUT;

    {
        STATE_LOGIN_IN.setContext(this);
        STATE_LOGIN_OUT.setContext(this);
    }

    public void setState(UserState state) {
        this.mCurrentState = state;
        this.mCurrentState.setContext(this);
    }

    public UserState getState() {
        return this.mCurrentState;
    }

    public void favorite() {
        this.mCurrentState.favorite();
    }

    public void comment(String comment) {
        this.mCurrentState.comment(comment);
    }

    public static void main(String[] args) {
        AppContext context = new AppContext();
        // 收藏
        context.favorite();
        // 评论
        context.comment("comment: good article.I like it!");
    }
}
