package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class BaseOnboardingScreen {
    protected final SelenideElement primaryTextView = $(id("org.wikipedia.alpha:id/primaryTextView"));
    private final SelenideElement forwardButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    @Step("Нажать кнопку для перехода")
    public void goToNextScreen() {
        forwardButton.click();
    }
}
