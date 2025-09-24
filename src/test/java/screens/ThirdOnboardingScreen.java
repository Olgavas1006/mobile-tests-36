package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;

public class ThirdOnboardingScreen extends BaseOnboardingScreen{

    @Step("Проверить третий экран онбординга")
    public void verifyThirdScreen() {
        primaryTextView.shouldHave(text("Reading lists with sync"));
    }
}
