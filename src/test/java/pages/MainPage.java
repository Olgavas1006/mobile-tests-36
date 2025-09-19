package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MainPage {
    private final SelenideElement clickWiki = $(accessibilityId("Search Wikipedia"));

    public void clickSearchWikipediaIcon() {
        clickWiki.click();
    }
}
