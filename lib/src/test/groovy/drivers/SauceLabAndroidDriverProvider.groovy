package drivers

import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.openqa.selenium.Capabilities
import org.openqa.selenium.MutableCapabilities
import org.openqa.selenium.WebDriver
import org.slf4j.helpers.CheckReturnValue

import javax.annotation.Nonnull
import javax.annotation.ParametersAreNonnullByDefault
import java.time.Duration

@ParametersAreNonnullByDefault
class SauceLabAndroidDriverProvider implements WebDriverProvider{
    @Override
    @CheckReturnValue
    @Nonnull
    WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android")
        caps.setCapability("appium:app", "storage:filename=TheApp.apk")  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator")
        caps.setCapability("appium:deviceOrientation", "portrait")
        caps.setCapability("appium:platformVersion", "12.0")
        caps.setCapability("appium:automationName", "UiAutomator2")
        //caps.setCapability("uiautomator2ServerInstallTimeout", 60000)
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv('USERNAME'))
        sauceOptions.setCapability("accessKey", System.getenv('ACCESS_KEY'))
        sauceOptions.setCapability("build", "appium-build-HBS50");
        sauceOptions.setCapability("name", "letsPlaySauceLabs");
        caps.setCapability("sauce:options", sauceOptions);

        try {
            return new AndroidDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
