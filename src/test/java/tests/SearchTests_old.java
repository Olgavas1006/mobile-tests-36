package tests;

import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class SearchTests_old {

    @Test
    void successfulSearchTest() throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();


        caps.setCapability("browserstack.user", "bsuser_Yucez9");
        caps.setCapability("browserstack.key", "3WgvoEGefTt5czbUhs6S");
        caps.setCapability("app", "bs://sample.app");
        caps.setCapability("device", "Samsung Galaxy S22 Ultra");
        caps.setCapability("os_version", "12.0");
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");
        RemoteWebDriver driver = new RemoteWebDriver(
                new URL("https://hub.browserstack.com/wd/hub"), caps);

        WebElement searchElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.accessibilityId("Search Wikipedia")));
        searchElement.click();
        WebElement insertTextElement = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("Appium");
        Thread.sleep(5000);
        List<WebElement> allProductsName = driver.findElements(AppiumBy.className(
                "android.widget.TextView"));
        assert (allProductsName.size() > 0);

        driver.quit();

    }
}
