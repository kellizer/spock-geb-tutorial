package com.spockgeb.geb

import geb.spock.GebReportingSpec

/**
 * Samples for the Spock/Geb Tutorials
 * @author Ian Kelly
 */
class GebReportingSpecWithPause extends GebReportingSpec {


    def pause() {
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
