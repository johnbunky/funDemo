package elements

import io.appium.java_client.AppiumBy

import static com.codeborne.selenide.Selenide.$

class Tabs {
    static def echoBoxTab = $(AppiumBy.accessibilityId('Echo Box'))
    static def loginScreenTab = $(AppiumBy.accessibilityId('Login Screen'))
    static def brokenImagesTab = $('[href="/broken_images"]')
}
