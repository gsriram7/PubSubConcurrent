package com.company;

public class Main {

    public static void main(String[] args) {
        MessageBroker messageBroker = new MessageBroker();
        Publisher publisher = new Publisher(messageBroker, 5, 10000);
        Subscriber subscriber = new Subscriber(messageBroker, 5);

        long start = System.currentTimeMillis();
        publisher.execute();
        subscriber.execute();

        publisher.waitForCompletion();
        subscriber.waitForCompletion();
        System.out.println("Total "+(System.currentTimeMillis() - start));
    }
}
