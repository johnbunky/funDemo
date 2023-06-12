package tests.web

import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.remote.DesiredCapabilities
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.comparison.ImageDiff
import ru.yandex.qatools.ashot.comparison.ImageDiffer
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider
import spock.lang.Specification
import javax.imageio.ImageIO
import pageObjects.pages.*

import static com.codeborne.selenide.Configuration.*
import static com.codeborne.selenide.Selenide.closeWebDriver
import static com.codeborne.selenide.WebDriverRunner.driver
import static com.codeborne.selenide.WebDriverRunner.getWebDriver
import static Variables.*

abstract class BaseTest extends Specification{
    def mainPage = MainPage
    def brokenImagesPage = BrokenImagesPage
    // screenshot comparison stuff
    static def baseline = 'src/test/resources/baselineImages/'
    static def comparison = 'build/reports/tests/screenshots/'
    def doBaseline = System.getProperty('baseline')

    void setupSpec() {
        // system properties in order to use one in command line
        def env = System.getProperty('env')
        def browserName = System.getProperty('browser')
        // screenshot comparison stuff
        reportsFolder = comparison
        // browser's stuff
        baseUrl = MAIN_URL
        screenshots = false
        savePageSource = false
        browserSize = '1920x1080'

        switch (env) {
            case "selenoid":
                remote = 'http://localhost:4444/wd/hub'
                break
            case 'remote':
                remote = 'http://52.14.11.186:4444/wd/hub'
                break
        }

        browser = browserName
        DesiredCapabilities capabilities = new DesiredCapabilities()
        Map<String, Object> selenoidOptions = new HashMap<>()
        selenoidOptions.put("enableVNC", true)
        selenoidOptions.put("enableVideo", true)
        capabilities.setCapability("selenoid:options", selenoidOptions)
        browserCapabilities = capabilities
    }

    void cleanupSpec() {
        closeWebDriver()
    }

    protected ImageDiff compareScreenshots(def testName, SelenideElement element) {
        // make screenshot
        def screenshot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(getWebDriver(), element)
        // get browser, environment and image names
        def browserName = driver().browser().name
        def environment = System.getProperty('env')
        def imageName = "${baseline}${testName}_${browserName}_${environment}.png"
        // save baseline image if it need
        if ( doBaseline == 'true' ) ImageIO.write(screenshot.getImage(), 'PNG', new File(imageName))
        // read existing baseline image
        def expectedImage = ImageIO.read(new File(imageName))
        // create output directory
        try {
            new File(comparison).mkdir()
        } catch (Exception ignored) {
        }
        // compare baseline image with screenshot
        def differences = new ImageDiffer().makeDiff(expectedImage, screenshot.getImage()).withDiffSizeTrigger(2000)
        if (differences.hasDiff()) {
            ImageIO.write(differences.getMarkedImage(), "PNG", new File("${comparison}${testName}.png"))
        }
        differences
    }
}
