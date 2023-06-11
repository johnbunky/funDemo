package drivers

import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.options.XCUITestOptions
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.slf4j.helpers.CheckReturnValue

import javax.annotation.Nonnull
import javax.annotation.ParametersAreNonnullByDefault
import java.time.Duration

@ParametersAreNonnullByDefault
class IOSDriverForApiDemos implements WebDriverProvider{
    @Override
    @CheckReturnValue
    @Nonnull
    WebDriver createDriver(Capabilities capabilities) {
        XCUITestOptions options = new XCUITestOptions()
                .merge(capabilities)
                .setPlatformName('iOS')
                .setPlatformVersion('14.4')
                .setDeviceName('iPhone 8')
                .setNewCommandTimeout(Duration.ofSeconds(11))
                .setFullReset(false)
                .setApp("/Users/you/Desktop/Projects/funDemo/lib/src/test/resources/TheApp.app.zip")

        try {
            return new IOSDriver( new URL("http://127.0.0.1:4723"), options )
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
