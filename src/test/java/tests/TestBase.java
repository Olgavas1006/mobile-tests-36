package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;


import static com.codeborne.selenide.Selenide.*;


public class TestBase {

    @BeforeAll
    static void setup() {
        String deviceHost = System.getProperty("deviceHost", "emulation");
        System.out.println("Running tests on: " + deviceHost);

        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "real":
            case "emulation":
            default:
                Configuration.browser = LocalDriver.class.getName();
                break;
        }

        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        Configuration.remote = null;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String deviceHost = System.getProperty("deviceHost", "emulation");

        if ("browserstack".equals(deviceHost)) {
            String sessionId = Selenide.sessionId().toString();
            Attach.pageSource();
            closeWebDriver();
            Attach.addVideo(sessionId);
        } else {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            closeWebDriver();
        }
    }
}