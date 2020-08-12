package com.xx.designpattern.BehaviorPattern.Mediator;

/**
 * @author xiaoxinga
 * @date 2020/06/09 11:27
 * @since
 */
public class ChatRoom {
    private ChatMediator mediator;

    public ChatRoom(ChatMediator mediator) {
        this.mediator = mediator;
        this.mediator.setChatRoom(this);
    }

    public void showMsg(User user, String msg) {
        System.out.println("[" + user.getName() + "]: " + msg);
    }

    public static void main(String[] args) {
        ChatMediator mediator = new ServerChatMediator();
        ChatRoom room = new ChatRoom(mediator);

        User john = new User("John", mediator);
        User whyn = new User("Whyn", mediator);
        john.sendMessage("Hi! I am John.");
        whyn.sendMessage("Hello! My name is Whyn.");
    }
}
