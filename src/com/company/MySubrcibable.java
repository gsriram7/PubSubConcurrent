package com.company;

public class MySubrcibable implements Runnable {

    private MessageBroker messageBroker;

    public MySubrcibable(MessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public void run() {
        String message;
        while (!messageBroker.messageQueue.isEmpty() && !messageBroker.messageQueue.peek().equals("End")) {
            message = messageBroker.messageQueue.poll();
            System.out.println(message);
        }
    }
}
