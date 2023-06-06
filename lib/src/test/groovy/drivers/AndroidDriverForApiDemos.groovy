package drivers

import com.codeborne.selenide.WebDriverProvider
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.openqa.selenium.Capabilities
import org.openqa.selenium.WebDriver
import org.slf4j.helpers.CheckReturnValue;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault
import java.time.Duration

@ParametersAreNonnullByDefault
class AndroidDriverForApiDemos implements WebDriverProvider{
    //static String username=  ""
    //static String accessKey= ""


    @Override
    @CheckReturnValue
    @Nonnull
    WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options()
                .merge(capabilities)
                .setPlatformName('Android')
                .setPlatformVersion('11.0')
                .setDeviceName('Android Emulator')
                //.setDeviceName('Google Pixel 4')
                .setNewCommandTimeout(Duration.ofSeconds(11))
                .setFullReset(false)
                .setApp("/Users/you/Desktop/Projects/funDemo/lib/src/test/resources/TheApp.apk") // TODO project path

        try {
            return new AndroidDriver( new URL("http://127.0.0.1:4723"), options )
            //return new AndroidDriver(new URL("http://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

