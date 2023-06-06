package elements.mobile

import static com.codeborne.selenide.Selenide.$x

class Alerts {
    static def alert = $x(('//XCUIElementTypeStaticText[@name="Alert"]'))
}
