package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import static com.codeborne.selenide.Selenide.$;

public class SkipOnboardingPage {
    private final SelenideElement skipButton = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));
    private final SelenideElement closeButton = $(AppiumBy.id("org.wikipedia.alpha:id/closeButton"));

    public void skipOnboardingIfVisible() {
        if (skipButton.isDisplayed()) {
            skipButton.click();
        }
        closeOnboardingIfNeeded();
    }

    public void closeOnboardingIfNeeded() {
        if (closeButton.isDisplayed()) {
            closeButton.click();
        }
    }

}
