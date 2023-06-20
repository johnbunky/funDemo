package elements

import io.appium.java_client.AppiumBy
import org.openqa.selenium.By

import static com.codeborne.selenide.Selenide.$
import static com.codeborne.selenide.appium.SelenideAppium.$x
import static helpers.LocatorDefiner.*

class InputFields {
    //static def messageInput =$x('//android.widget.EditText[@content-desc="messageInput"]')
    static By messageInput_ios = AppiumBy.className('XCUIElementTypeTextField')
    static By messageInput_android = AppiumBy.className('android.widget.EditText')
    static def messageInput = $(defineLocator(messageInput_android, messageInput_ios))
}
