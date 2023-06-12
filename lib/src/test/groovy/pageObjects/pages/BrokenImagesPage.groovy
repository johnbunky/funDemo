package pageObjects.pages

import static com.codeborne.selenide.Selenide.$

class BrokenImagesPage {
    static def brokenImage = $('[src="img/avatar-blank.jpg"]')
}
