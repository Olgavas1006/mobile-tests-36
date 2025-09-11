package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();
        MobileConfig config = ConfigFactory.create(MobileConfig.class);

        caps.setCapability("browserstack.user", config.bsUser());
        caps.setCapability("browserstack.key", config.bsKey());

        caps.setCapability("app", config.app());

        caps.setCapability("platformName", config.platformName());
        caps.setCapability("device", config.deviceName());
        caps.setCapability("os_version", config.osVersion());

        caps.setCapability("project", config.projectName());
        caps.setCapability("build", config.buildName());
        caps.setCapability("name", config.sessionName());


        try {
            return new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid URL for BrowserStack", e);
        }
    }
}


