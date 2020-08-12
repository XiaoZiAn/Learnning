package com.xx.designpattern.BehaviorPattern.Mediator;

/**
 * @author xiaoxinga
 * @date 2020/06/09 11:26
 * @since
 */
public class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void sendMessage(String msg) {
        this.mediator.send2ChatRoom(this, msg);
    }
}
