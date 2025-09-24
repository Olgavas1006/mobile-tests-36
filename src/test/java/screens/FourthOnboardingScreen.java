package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class FourthOnboardingScreen extends BaseOnboardingScreen{

    @Step("Проверить четвертый экран онбординга")
    public void verifyFourthScreen() {
        primaryTextView.shouldHave(text("Data & Privacy"));
    }
}
