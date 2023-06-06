package tests.mobile

import com.codeborne.selenide.appium.SelenideAppium
import drivers.AndroidDriverForApiDemos
import drivers.IOSDriverForApiDemos

import static com.codeborne.selenide.Condition.visible
import static com.codeborne.selenide.Configuration.*

class MobileTest extends BaseTest {
    def "Echo Box tab works well on Android"() {
        setup:
        browser = AndroidDriverForApiDemos.class.getName()
        SelenideAppium.launchApp()

        when:
        mainActivity.echoBoxTab.click()
        then:
        echoActivity.messageInputField.shouldBe(visible)
    }

    def "empty input Alert Login Screen on iOS"() {
        setup:
        browser = IOSDriverForApiDemos.class.getName()
        SelenideAppium.launchApp()

        when:
        mainActivity.loginScreenTab.click()
        loginActivity.loginBtn.click()
        then:
        loginActivity.alert.shouldBe(visible)
    }
}
