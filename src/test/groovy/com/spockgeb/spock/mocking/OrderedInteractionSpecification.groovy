package com.spockgeb.spock.mocking

import com.spockgeb.tutorial.spock.subscribe.Event
import com.spockgeb.tutorial.spock.subscribe.Publisher
import com.spockgeb.tutorial.spock.subscribe.StandardPublisher
import com.spockgeb.tutorial.spock.subscribe.Subscriber
import spock.lang.Specification

/**
 *
 */
class OrderedInteractionSpecification extends Specification {

    def "example showing the ordered interaction"() {
        given:
        def subscriber1 = Mock(Subscriber)
        Subscriber subscriber2 = Mock()
        Subscriber subscriber3 = Mock()
        def event = Mock(Event)

        //note the groovy shortcut to populate setters and object construction
        Publisher publisher = new StandardPublisher(subscribers: [subscriber1, subscriber2, subscriber3]);
        when:
        publisher.send(event)
        then:
        1 * subscriber1.receive(event)
        1 * subscriber2.receive(_ as Event) //any Events can be passed in..
        // order of interaction within same then-block is not defined;
        // hence, subscriber1 might be notified either before or after subscriber2
        then:
        // must come after all interactions in previous then-blocks;
        // hence, subscriber3 must be notified after both subscriber1 and subscriber2
        1 * subscriber3.receive(event)
    }

    /**
     * loading the subscribers using the left shift
     * subscriber 3 has
     */
    def "example showing the ordered interaction with a few differences"() {
        given:
        def subscriber1 = Mock(Subscriber)
        Subscriber subscriber2 = Mock()
        Subscriber subscriber3 = Mock()
        //note the groovy shortcut to populate setters and object construction
        Publisher publisher = new StandardPublisher();
        publisher.subscribers << subscriber1 << subscriber2 << subscriber3

        Event event = Mock()
        when:
        publisher.send(event)
        then:
        1 * subscriber1.receive(event)
        1 * subscriber2.receive(_ as Event) //any Events can validated..
        // order of interaction within same then-block is not defined;
        // hence, subscriber1 might be notified either before or after subscriber2
        then:
        // must come after all interactions in previous then-blocks;
        // hence, subscriber3 must be notified after both subscriber1 and subscriber2
        1 * subscriber3._(_)
    }
}
