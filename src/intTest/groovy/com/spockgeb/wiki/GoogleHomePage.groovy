package com.spockgeb.wiki

import geb.Page

class GoogleHomePage extends Page {
    static url = "http://google.com/ncr"
    static at = { title == "Google" }
}