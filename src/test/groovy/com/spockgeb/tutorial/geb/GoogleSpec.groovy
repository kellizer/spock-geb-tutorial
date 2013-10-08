package com.spockgeb.tutorial.geb

import geb.spock.*

class GoogleSpec extends GebReportingSpec {

    def "the first link should be wikipedia"() {
        when:
        to GoogleHomePage

        and:
        q = "wikipedia"

        then:
        geb.Page.at GoogleResultsPage

        and:
        firstResultLink.text() == "Wikipedia"

        when:
        firstResultLink.click()

        then:
        waitFor { at WikipediaPage }
    }

}