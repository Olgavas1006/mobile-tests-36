package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static com.codeborne.selenide.Selenide.$;

public class SearchScreen {
    private final SelenideElement inputElement = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection listElement = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    private final ElementsCollection sizeContent = $$(className("android.widget.TextView"));
    private final SelenideElement articleTitle = $(byXpath("//*[@text='GitHub']"));

    @Step("Ввести значение в поле поиска")
    public void searchPageSetValue(String value){
        inputElement.sendKeys(value);
    }

    @Step("Нажать на первый результат в списке")
    public void clickTheFirstResult(){
        listElement.first().click();
    }

    @Step("Проверить наличие результатов поиска")
    public void verifyContent(){
        sizeContent.shouldHave(sizeGreaterThan(0));
    }


    @Step("Проверить заголовок статьи")
    public void verifyArticleTitle(String expectedTitle) {
        articleTitle.shouldBe(visible);

    }
}
