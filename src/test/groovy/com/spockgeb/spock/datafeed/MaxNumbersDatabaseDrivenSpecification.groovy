package com.spockgeb.spock.datafeed

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
class MaxNumbersDatabaseDrivenSpecification extends Specification {

    //a heavyweight resource
    //@spock.lang.AutoCleanup
    @Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    // normally an external database would be used,
    // and the test data wouldn't have to be inserted here
    def setupSpec() {
        //setup the schema
        sql.execute("create table maxdata (id int primary key, a int, b int, c int)")

        //now populate the values.
        sql.execute("insert into maxdata values (1, 3, 7, 7), (2, 5, 4, 5), (3, 9, 9, 9)")
    }


    @Unroll //see all the tests.
    def "maximum of two numbers, a=#a, b=#b so max would be #c"() {
        expect:
        Math.max(a, b) == c

        where:
        [a, b, c] << sql.rows("select a, b, c from maxdata")
    }

    //not really need for an in memory DB.
    def cleanupSpec() {
        sql.close()
    }
}
