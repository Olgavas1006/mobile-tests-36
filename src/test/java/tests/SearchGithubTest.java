package tests;

import org.junit.jupiter.api.*;
import screens.MainScreen;
import screens.SkipOnboardingScreen;
import screens.SearchScreen;
import static io.qameta.allure.Allure.step;


public class SearchGithubTest extends TestBase{

    MainScreen mainScreen = new MainScreen();
    SearchScreen searchScreen = new SearchScreen();
    SkipOnboardingScreen onboardingScreen = new SkipOnboardingScreen();


    @Tag("android")
    @Test
    void openArticleTest() {
        step("Пропустить онбординг если отображается", () -> {
            onboardingScreen.skipOnboardingIfVisible();
        });

        step("Открыть поиск и ввести Github", () -> {
            mainScreen.clickSearchWikipediaIcon();
            searchScreen.searchPageSetValue("Github");
        });

        step("Открыть первую статью из результатов", () -> {
            searchScreen.clickTheFirstResult();
        });

        step("Закрыть всплывающее окно если отображается", () -> {
                Thread.sleep(1000);
                 onboardingScreen.closeOnboardingIfNeeded();
        });

        step("Проверить найденный контент", () -> {
            searchScreen.verifyContent();
        });

        step("Проверить заголовок статьи", () -> {
            searchScreen.verifyArticleTitle("GitHub");
        });
    }

}
