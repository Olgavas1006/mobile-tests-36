package tests;

import org.junit.jupiter.api.*;
import pages.MainPage;
import pages.SearchPage;
import static io.qameta.allure.Allure.step;

public class SearchGithubTest extends TestBase{

    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();


    @Test
    void openArticleTest() {
        step("Открыть поиск и ввести Github", () -> {
            mainPage.clickSearchWikipediaIcon();
            searchPage.searchPageSetValue("Github");

        });

        step("Открыть первую статью из результатов", () -> {
            searchPage.clickTheFirstResult();
        });

        step("Проверить найденный контент", () -> {
            searchPage.verifyContent();
        });
    }
}
