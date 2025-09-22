package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.LocalConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;


public class LocalDriver implements WebDriverProvider {

    private static final LocalConfig config = ConfigFactory.create(LocalConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(config.getPlatformVersion())
                .setDeviceName(config.getDeviceName())
                .setAppPackage("org.wikipedia.alpha")
                .setAppActivity("org.wikipedia.main.MainActivity")
                .setNoReset(false)
                .setFullReset(false);

        return new AndroidDriver(getAppiumServerUrl(), options);
    }


    private String getAppPath() {
        return "";
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL("http://localhost:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}