package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.FirstOnboardingScreen;
import screens.FourthOnboardingScreen;
import screens.SecondOnboardingScreen;
import screens.ThirdOnboardingScreen;

import static io.qameta.allure.Allure.step;

public class WikiOnboardingTest extends TestBase {

    FirstOnboardingScreen firstScreen = new FirstOnboardingScreen();
    SecondOnboardingScreen secondScreen = new SecondOnboardingScreen();
    ThirdOnboardingScreen thirdScreen = new ThirdOnboardingScreen();
    FourthOnboardingScreen fourthScreen = new FourthOnboardingScreen();

    @Tag("android")
    @Test
    @DisplayName("Проверка экранов онбординга")
    void verifyGettingStartedScreensTest() {
        step("Проверить первый экран", () -> {
            firstScreen.verifyFirstScreen();
            firstScreen.goToNextScreen();
        });

        step("Проверить второй экран", () -> {
            secondScreen.verifySecondScreen();
            secondScreen.goToNextScreen();
        });

        step("Проверить третий экран", () -> {
            thirdScreen.verifyThirdScreen();
            thirdScreen.goToNextScreen();
        });

        step("Проверить четвертый экран", () -> {
            fourthScreen.verifyFourthScreen();
        });
    }
}
