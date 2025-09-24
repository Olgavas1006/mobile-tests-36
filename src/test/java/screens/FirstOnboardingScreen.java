package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class FirstOnboardingScreen extends BaseOnboardingScreen {

    @Step("Проверить первый экран онбординга")
    public void verifyFirstScreen() {
        primaryTextView.shouldHave(text("The Free Encyclopedia"));
    }
}
