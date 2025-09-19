package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class WikiOnboardingTest extends TestBase {

    @Test
    void successfulSearchTest() {
        step("Проверяем первую страницу онбординга", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.exist);
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверяем вторую страницу онбординга", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверяем третью страницу онбординга", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Проверяем четвертую страницу онбординга", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(Condition.text("Send anonymous data"));
            $(AppiumBy.id("org.wikipedia.alpha:id/rejectButton")).click();
        });
        step("Проверяем, что открылась главная страница", () ->
                $(AppiumBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark"))
                        .shouldBe(Condition.visible));
    }
}
