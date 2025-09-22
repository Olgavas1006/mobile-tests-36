package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.OnboardingPage;
import static io.qameta.allure.Allure.step;

public class WikiOnboardingTest extends TestBase {
    OnboardingPage onboardingPage = new OnboardingPage();

    @Test
    @DisplayName("Проверка экранов онбординга")
    void verifyGettingStartedScreensTest() {
        step("Проверить первый экран", () -> {
            onboardingPage.verifyFirstScreen();
            onboardingPage.goToNextScreen();
        });

        step("Проверить второй экран", () -> {
            onboardingPage.verifySecondScreen();
            onboardingPage.goToNextScreen();
        });

        step("Проверить третий экран", () -> {
            onboardingPage.verifyThirdScreen();
            onboardingPage.goToNextScreen();
        });

        step("Проверить четвертый экран", () -> {
            onboardingPage.verifyFourthScreen();
        });
    }
}
