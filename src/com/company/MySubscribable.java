package com.company;

public class MySubscribable implements Runnable {

    private final String name;
    private MessageBroker messageBroker;

    public MySubscribable(String name, MessageBroker messageBroker) {
        this.name = name;
        this.messageBroker = messageBroker;
    }

    @Override
    public void run() {
        String message;
        try {
            while (!messageBroker.messageQueue.isEmpty() && (messageBroker.toContinue(message = messageBroker.messageQueue.take()))) {
                if (!message.equals("End"))
                    System.out.println("From "+name+" :" +message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
