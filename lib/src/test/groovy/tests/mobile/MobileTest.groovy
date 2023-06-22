package tests.mobile

import spock.lang.*
import static com.codeborne.selenide.Condition.visible

class MobileTest extends BaseTest {
    def "Echo Box tab works well"() {
        when:
        mainActivity.echoBoxTab.click()
        then:
        echoActivity.messageInputField.shouldBe(visible)
    }
    @Tag('ttt')
    def "empty input  Login Screen alert"() {
        when:
        mainActivity.loginScreenTab.click()
        loginActivity.loginBtn.click()
        then:
        loginActivity.alert.shouldBe(visible)
    }
}
