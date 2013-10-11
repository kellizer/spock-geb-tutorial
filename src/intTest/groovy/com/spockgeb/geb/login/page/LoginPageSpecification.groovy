package com.spockgeb.geb.login.page

import com.spockgeb.geb.GebReportingSpecWithPause
import com.spockgeb.geb.wiki.page.GoogleHomePage

/**
 *Geb & Spock Tutorials,
 * @author Ian Kelly
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

    def "Login to The Secure Admin Server and confirm there are the correct number of employees"() {
        when:
        to LoginPage
        login("admin", "password")
        then:
        at AuthenticatedAdminPage
        users.size()==4
    }

    def "Login to The Secure Admin Server and confirm the first user is Joe"() {
        when:
        to LoginPage
        login("admin", "password")
        then:
        at AuthenticatedAdminPage
        userName(0).text()=='Joe Bond'
    }

    def "Login to The Secure Admin Server and confirm the first user is Joe via modules"() {
        when:
        to LoginPage
        login("admin", "password")
        then:
        at AuthenticatedAdminPageWithModules
        users(0).userName.text()=='Joe Bond'
    }
}
