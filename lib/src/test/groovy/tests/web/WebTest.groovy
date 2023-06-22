package tests.web

import spock.lang.*
import static com.codeborne.selenide.Configuration.baseUrl
import static com.codeborne.selenide.Selenide.open
import static org.junit.Assert.assertFalse

class WebTest extends BaseTest{
    @Tag('ttt')
    def 'compare image'() {
        given:
        def actualScreenshot = brokenImagesPage.brokenImage
        open baseUrl
        when:
        mainPage.brokenImageTab.click() 
        then:
        assertFalse("Screenshot has difference", compareScreenshots('expectedScreenshot', actualScreenshot).hasDiff())
    }
}
