package com.spockgeb.geb.login.page

import geb.Page

/**
 * Model of our Login Page
 */
class LoginPage extends Page {

    //relative url
    static url = "/login.html"
    //implicit assertion
    static at = { title == "Admin Login" }
    static content =
        {
            titleHeading {
                $("legend")
            }
        }

    void login(String username, String password) {
        $("input[name=username]").value(username)
        $("input[name=password]").value(password)
        $("button").click()
    }

}
