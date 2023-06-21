package tests.mobile

import com.codeborne.selenide.appium.SelenideAppium
import drivers.*
import pageObjects.activities.*

import static com.codeborne.selenide.Configuration.browser
import static com.codeborne.selenide.Selenide.closeWebDriver
import spock.lang.Specification

abstract class BaseTest extends Specification {
    def mainActivity = MainActivity
    def echoActivity = EchoActivity
    def loginActivity = LoginActivity

    void setupSpec() {
        def env = System.getProperty('mobile')

        switch (env) {
            case "android_local":
                browser = AndroidDriverForApiDemos.class.getName()
                break
            case 'android_remote':
                browser = SauceLabAndroidDriverProvider.class.getName()
                break
            case "ios_local":
                browser = IOSDriverForApiDemos.class.getName()
                break
            case 'ios_remote':
                browser = SauceLabIOSDriverProvider.class.getName()
                break
            default:
                println("Unknown mobile device")
        }
        SelenideAppium.launchApp()
    }

    void cleanupSpec(){
        closeWebDriver()
    }
}
