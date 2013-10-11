package com.spockgeb.geb.login.page

import geb.Page

/**
 *
 */
class AuthenticatedAdminPage extends Page {
    //implicit assertion
    static at = { title == "Authenticated User" }
    static content =
            {
                //optional content
                administratorsName(required: false)
                        {
                            $("h2")
                        }
                //stacked
                users(wait: true) { $("li.span5.clearfix") }
                user { i -> users[i] }
                userName { i -> users[i].find("h4", 0) }
            }
}
