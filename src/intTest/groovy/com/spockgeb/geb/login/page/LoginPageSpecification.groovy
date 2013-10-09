package com.spockgeb.geb.login.page

import com.spockgeb.geb.GebReportingSpecWithPause
import com.spockgeb.geb.wiki.page.GoogleHomePage

/**
 *
 */
class LoginPageSpecification extends GebReportingSpecWithPause {

    def "Goto Admin Server Login Page"() {
        when:
        to LoginPage
        then:
        title == 'Admin Login'
        titleHeading.text() == "Sign-in to our secure Admin Server"
    }

    def "Login to The Secure Admin Server"() {
        when:
        to LoginPage
        login("admin", "password")
        then:
        at AuthenticatedAdminPage
    }
}
