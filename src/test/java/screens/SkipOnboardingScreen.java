package screens;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SkipOnboardingScreen {
    private final SelenideElement skipButton = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));
    private final SelenideElement closeButton = $(AppiumBy.id("org.wikipedia.alpha:id/closeButton"));

    @Step("Пропустить онбординг")
    public void skipOnboardingIfVisible() {
        if (skipButton.isDisplayed()) {
            skipButton.click();
        }
        closeOnboardingIfNeeded();
    }

    @Step("Закрыть всплывающие подсказки")
    public void closeOnboardingIfNeeded() {
        if (closeButton.isDisplayed()) {
            closeButton.click();
        }
    }

}
