package com.xx.designpattern.BehaviorPattern.Mediator;

/**
 * @author xiaoxinga
 * @date 2020/06/09 11:27
 * @since
 */
public abstract class ChatMediator {
    protected ChatRoom room;

    public void setChatRoom(ChatRoom room) {
        this.room = room;
    }

    public abstract void send2ChatRoom(User user, String msg);
}
