package com.spockgeb.geb.wiki

import com.spockgeb.geb.GebReportingSpecWithPause
import com.spockgeb.geb.wiki.page.GoogleHomePage
import com.spockgeb.geb.wiki.page.GoogleResultsPage
import com.spockgeb.geb.wiki.page.WikipediaPage
import geb.spock.*

class GoogleSpec extends GebReportingSpecWithPause {

    def "the first link should be wikipedia"() {
        when:
        to GoogleHomePage
        pause()
        and:
        q = "wikipedia"
        then:
        at GoogleResultsPage
        and:
        firstResultLink.text() == "Wikipedia"
        when:
        firstResultLink.click()
        then:
        waitFor { at WikipediaPage }
    }
}