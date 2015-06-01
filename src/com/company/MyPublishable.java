package com.company;

public class MyPublishable implements Runnable {

    private final String message;
    private MessageBroker messageBroker;

    public MyPublishable(String message, MessageBroker messageBroker) {
        this.message = message;
        this.messageBroker = messageBroker;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            messageBroker.messageQueue.add(message+i);
        }
        messageBroker.messageQueue.add("End");
    }
}
