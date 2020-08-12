package com.xx.designpattern.BehaviorPattern.Mediator;

/**
 * @author xiaoxinga
 * @date 2020/06/09 11:27
 * @since
 */
public class ServerChatMediator extends ChatMediator {
    @Override
    public void send2ChatRoom(User user, String msg) {
        this.room.showMsg(user,msg);
    }
}
