package tests.web

import static com.codeborne.selenide.Condition.*
import static com.codeborne.selenide.Configuration.baseUrl
import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.Selenide.open
import static org.junit.Assert.assertFalse

class WebTest extends BaseTest{
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
