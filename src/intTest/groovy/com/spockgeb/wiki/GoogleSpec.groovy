package com.spockgeb.wiki

import geb.spock.*

class GoogleSpec extends GebReportingSpec {

    def "the first link should be wikipedia"() {
        when:
        to GoogleHomePage
        pause()
        and:
        q = "wikipedia"
        then:
        at GoogleResultsPage
        and:
        firstResultLink.text() == "Wikipedia"
        when:
        firstResultLink.click()
        then:
        waitFor { at WikipediaPage }
    }

    private void pause() {
        js.exec """
            (function() {
                window.__gebPaused = true;
                var div = document.createElement("div");
                div.setAttribute('style', "\\
                    position: absolute; top: 0px;\\
                    z-index: 3000;\\
                    padding: 10px;\\
                    background-color: red;\\
                    border: 2px solid black;\\
                    border-radius: 2px;\\
                    text-align: center;\\
                ");

                var button = document.createElement("button");
                button.innerHTML = "Unpause Geb";
                button.onclick = function() {
                    window.__gebPaused = false;
                }
                button.setAttribute("style", "\\
                    font-weight: bold;\\
                ");

                div.appendChild(button);
                document.getElementsByTagName("body")[0].appendChild(div);
            })();
        """

        waitFor(300) { !js.__gebPaused }
    }

}