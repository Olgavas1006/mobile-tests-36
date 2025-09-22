package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingPage {
    private final SelenideElement primaryTextView = $(id("org.wikipedia.alpha:id/primaryTextView"));
    private final SelenideElement forwardButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));

    public void verifyFirstScreen() {
        primaryTextView.shouldHave(text("The Free Encyclopedia"));
    }

    public void verifySecondScreen() {
        primaryTextView.shouldHave(text("New ways to explore"));
    }

    public void verifyThirdScreen() {
        primaryTextView.shouldHave(text("Reading lists with sync"));
    }

    public void verifyFourthScreen() {
        primaryTextView.shouldHave(text("Data & Privacy"));
    }

    public void goToNextScreen() {
        forwardButton.click();
    }

}
