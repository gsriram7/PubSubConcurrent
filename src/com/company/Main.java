package com.company;

public class Main {

    public static void main(String[] args) {
        int publisherThreads = Integer.parseInt(args[0]);
        int subscriberThreads = Integer.parseInt(args[1]);
        MessageBroker messageBroker = new MessageBroker(publisherThreads);
        int numMessages = Integer.parseInt(args[2]) / publisherThreads;
        Publisher publisher = new Publisher(messageBroker, publisherThreads, numMessages);
        Subscriber subscriber = new Subscriber(messageBroker, subscriberThreads);

        long start = System.currentTimeMillis();
        publisher.execute();
        subscriber.execute();

        System.out.println("Total "+(System.currentTimeMillis() - start));
    }
}
