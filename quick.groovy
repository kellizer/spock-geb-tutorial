Browser.drive {
    go "http://myapp.com/login"

    // login
    username = "me"
    password = "secret"
    login().click()

    // now find the pdf download link
    def downloadLink = $("a.pdf-download-link")

    // now get the pdf bytes
    def bytes = downloadBytes(downloadLink.@href)