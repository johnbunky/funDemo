package tests.mobile

import com.codeborne.selenide.appium.SelenideAppium
import drivers.SauceLabAndroidDriverProvider
import drivers.IOSDriverForApiDemos
import drivers.SauceLabIOSDriverProvider
import spock.lang.*

import static com.codeborne.selenide.Condition.visible
import static com.codeborne.selenide.Configuration.*
import static com.codeborne.selenide.Selenide.open

class MobileTest extends BaseTest {
    def "Echo Box tab works well on Android"() {
        setup:
        browser = SauceLabAndroidDriverProvider.class.getName()
        //browser = AndroidDriverForApiDemos.class.getName()
        SelenideAppium.launchApp()

        when:
        mainActivity.echoBoxTab.click()
        then:
        echoActivity.messageInputField.shouldBe(visible)
    }
    @Tag('ios')
    def "empty input Alert Login Screen on iOS"() {
        setup:
        browser = SauceLabIOSDriverProvider.class.getName()
        //browser = IOSDriverForApiDemos.class.getName()
        SelenideAppium.launchApp()

        when:
        mainActivity.loginScreenTab.click()
        loginActivity.loginBtn.click()
        then:
        loginActivity.alert.shouldBe(visible)
    }
}
