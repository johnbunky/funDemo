package tests.mobile

import pageObjects.activities.*

import static com.codeborne.selenide.Selenide.closeWebDriver
import spock.lang.Specification

abstract class BaseTest extends Specification {
    def mainActivity = MainActivity
    def echoActivity = EchoActivity
    def loginActivity = LoginActivity

    void cleanupSpec(){
        closeWebDriver()
    }
}
