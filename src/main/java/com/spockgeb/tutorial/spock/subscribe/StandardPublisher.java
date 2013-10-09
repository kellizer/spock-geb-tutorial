package com.spockgeb.tutorial.spock.subscribe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class StandardPublisher implements Publisher {

    private List<Subscriber> subscribers = new ArrayList<>();


    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void send(Event event) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receive(event);
        }

    }
}
