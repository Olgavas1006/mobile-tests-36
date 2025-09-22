package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.SkipOnboardingPage;
import pages.SearchPage;
import static io.qameta.allure.Allure.step;


public class SearchGithubTest extends TestBase{
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    SkipOnboardingPage onboardingPage = new SkipOnboardingPage();




    @Tag("android")
    @Test
    void openArticleTest() {
        step("Пропустить онбординг если отображается", () -> {
            onboardingPage.skipOnboardingIfVisible();
        });

        step("Открыть поиск и ввести Github", () -> {
            mainPage.clickSearchWikipediaIcon();
            searchPage.searchPageSetValue("Github");
        });

        step("Открыть первую статью из результатов", () -> {
            searchPage.clickTheFirstResult();
        });

        step("Закрыть всплывающее окно если отображается", () -> {
                Thread.sleep(1000);
                 onboardingPage.closeOnboardingIfNeeded();
        });
        step("Проверить найденный контент", searchPage::verifyContent);

        step("Проверить заголовок статьи", () -> {
            searchPage.verifyArticleTitle("GitHub");
        });
    }

}
