package com.spockgeb.geb.wiki.page

import geb.Page

class GoogleHomePage extends Page {
    static url = "http://google.com/ncr"
    static at = { title == "Google" }
}