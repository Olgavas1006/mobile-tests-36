package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class SecondOnboardingScreen extends BaseOnboardingScreen{

    @Step("Проверить второй экран онбординга")
    public void verifySecondScreen() {
        primaryTextView.shouldHave(text("New ways to explore"));
    }
}
