package com.spockgeb.wiki

import geb.Page

class WikipediaPage extends Page {
    static at = { title == "Wikipedia, the free encyclopedia" }
}