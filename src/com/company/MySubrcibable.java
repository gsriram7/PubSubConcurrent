package com.company;

public class MySubrcibable implements Runnable {

    private final String name;
    private MessageBroker messageBroker;

    public MySubrcibable(String name, MessageBroker messageBroker) {
        this.name = name;
        this.messageBroker = messageBroker;
    }

    @Override
    public void run() {
        String message;
        while (!messageBroker.messageQueue.isEmpty() && !messageBroker.messageQueue.peek().equals("End")) {
            message = messageBroker.messageQueue.poll();
            System.out.println("From "+name+" :" +message);
        }
    }
}
