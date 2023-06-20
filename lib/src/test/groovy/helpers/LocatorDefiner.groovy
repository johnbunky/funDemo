package helpers

import com.codeborne.selenide.appium.AppiumDriverRunner
import org.openqa.selenium.By

final class LocatorDefiner {
    static By defineLocator(By androidBy, By iosBy) {
        return AppiumDriverRunner.isAndroidDriver()
                ? androidBy
                : iosBy
    }
}
