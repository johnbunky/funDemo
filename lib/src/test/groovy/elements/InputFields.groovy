package elements

import static com.codeborne.selenide.appium.SelenideAppium.$x

class InputFields {
    static def messageInput =$x(('//android.widget.EditText[@content-desc="messageInput"]'))
}
