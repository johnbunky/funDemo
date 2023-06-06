package pageObjects.activities

import elements.mobile.Alerts

import static com.codeborne.selenide.Selenide.$x

class LoginActivity {
    static def loginBtn = $x(('(//XCUIElementTypeOther[@name="loginBtn"])[2]'))
    static def alert = Alerts.alert
}
