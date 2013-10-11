package com.spockgeb.geb.login.page

import geb.Module
import geb.Page

/**
 *
 */
class AuthenticatedAdminPageWithModules extends Page {

    static at = { title == "Authenticated User" }

    static content =
            {
                users
                        {
                            //scoped user
                            userNumber -> module UserRow, $("li.span5.clearfix", userNumber)
                        }

            }
}

class UserRow extends Module {
    static content =
            {
                //stacked
                userName { i -> $("h4") }
            }
}
