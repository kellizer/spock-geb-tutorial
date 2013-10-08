package com.spockgeb.tutorial.geb

import geb.Page

class WikipediaPage extends Page {
    static at = { title == "Wikipedia" }
}