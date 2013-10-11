package com.spockgeb.geb.login.story

import com.spockgeb.geb.GebReportingSpecWithPause
import spock.lang.Stepwise

/**
 *
 */
@Stepwise
class LoginStorySpecification extends GebReportingSpecWithPause {

    def "Navigate to the login page"() {
        when:
        go "/login.html"
        then:
        title == "Admin Login"
        $("legend").text() == "Sign-in to our secure Admin Server"
        //make sure we have username/password
        $("form").find("input[type=text],input[type=password]").size() == 2
    }

    def "Login with an correct password"() {
        given:
        go "/login.html"
        $("form").with {
            username = 'admin'
            password = 'password'
            remember = true
        }
        when:
        $("button").click()
        then:
        title == "Authenticated User"
    }

    /**
     * set control values based simply on its name, controls being input,select,textarea
     */
  def "quickly set form values"() {
        given:
        go "/login.html"
        when:
        username = "Ian"
        pause()
        then:
        username=='Ian' //same for reading..
    }

    def "Login with an in-correct password"() {
        given:
        go "/login.html"
        $("form").with {
            username = 'admin'
            password = 'no-correct-password'
            remember = true
        }
        when:
        $("button").click()
        then:
        title == "Login Failed"
    }


}
