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
        def subscriber1 = Mock(Subscriber) // "dynamic" style (mock name inferred from variable name)
        Subscriber subscriber2 = Mock()    // "static" style" (mock name and type inferred from variable name and type)
        Subscriber subscriber3 = Mock()
        Publisher publisher = new StandardPublisher(subscribers: [subscriber1, subscriber2,subscriber3]);
        Event event = Mock()
        when:
        publisher.send(event)
        then:
        1 * subscriber1.receive(event)
        1 * subscriber2.receive(event)
        // order of interaction within same then-block is not defined;
        // hence, subscriber1 might be notified either before or after subscriber2
        then:
        // must come after all interactions in previous then-blocks;
        // hence, subscriber3 must be notified after both subscriber1 and subscriber2
        1 * subscriber3.receive(event)
    }
}
