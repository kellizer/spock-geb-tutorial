package com.spockgeb.geb.wiki.page

import geb.Page

class WikipediaPage extends Page {
    static at = { title == "Wikipedia, the free encyclopedia" }
}