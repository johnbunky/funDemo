package drivers

import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import org.openqa.selenium.Capabilities
import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.slf4j.helpers.CheckReturnValue
import javax.annotation.Nonnull
import javax.annotation.ParametersAreNonnullByDefault
import static Variables.*

@ParametersAreNonnullByDefault
class SauceLabIOSDriverProvider implements WebDriverProvider {
    @Override
    @CheckReturnValue
    @Nonnull
    WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities()
        caps.setCapability("platformName", "iOS")
        caps.setCapability("appium:app", "storage:filename=TheApp.app.zip")
        caps.setCapability("appium:deviceName", "iPhone Simulator")
        caps.setCapability("appium:deviceOrientation", "portrait")
        caps.setCapability("appium:platformVersion", "16.1")
        caps.setCapability("appium:automationName", "XCUITest")
        MutableCapabilities sauceOptions = new MutableCapabilities()
        sauceOptions.setCapability("username", System.getenv('USERNAME'))
        sauceOptions.setCapability("accessKey", System.getenv('ACCESS_KEY'))
        sauceOptions.setCapability("build", "appium-build-HBS50")
        sauceOptions.setCapability("name", "letsPlayIOSSauceLab")
        caps.setCapability("sauce:options", sauceOptions)

        try {
            return new IOSDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
