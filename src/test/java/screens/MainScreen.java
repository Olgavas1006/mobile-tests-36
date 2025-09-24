package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class MainScreen {
    private final SelenideElement clickWiki = $(accessibilityId("Search Wikipedia"));

    @Step("Нажать на иконку поиска Wikipedia")
    public void clickSearchWikipediaIcon() {
        clickWiki.click();
    }
}
