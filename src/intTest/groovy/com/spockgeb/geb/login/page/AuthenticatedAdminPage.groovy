package com.spockgeb.geb.login.page

import geb.Page

/**
 *
 */
class AuthenticatedAdminPage extends Page {

    static at = { title == "Logged In" }

}
