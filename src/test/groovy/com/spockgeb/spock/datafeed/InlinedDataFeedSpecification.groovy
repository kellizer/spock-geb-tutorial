package com.spockgeb.spock.datafeed

import com.spockgeb.tutorial.spock.DateService
import spock.lang.Specification
import spock.lang.Unroll

import java.text.SimpleDateFormat

/**
 *
 */
class InlinedDataFeedSpecification extends Specification {

    def dateService = new DateService();

    def "Validate Age Calculation From DOB"() {
        when:
        Date date = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH).parse(dob)
        def calculatedAge = dateService.ageFromDOB(date)
        then:
        calculatedAge == age
        where:
        dob          || age
        "01-02-1980" || 33
        "01-01-1990" || 23
        "12-12-1958" || 55
    }

    @Unroll
    def "Validate that #name's age (#age) is correct when their DOB is #dob"() {
        when:
        Date date = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH).parse(dob)
        def calculatedAge = dateService.ageFromDOB(date)
        then:
        calculatedAge == age
        where:
        name       | dob          || age
        "Ian"      | "01-02-1980" || 33
        "Anna"     | "01-01-1990" || 23
        "Carolina" | "12-12-1958" || 55
        "Jane"     | "01-04-1985" || 61
    }


}


