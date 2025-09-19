package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulatorConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class EmulationDriver implements WebDriverProvider {

    private static final EmulatorConfig config = ConfigFactory.create(EmulatorConfig.class);

    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName(config.deviceName())
                .setPlatformVersion(config.platformVersion())
                .setAppPackage("org.wikipedia.alpha")
                .setAppActivity("org.wikipedia.main.MainActivity")
                .setAvd(config.deviceName())
                .setAvdLaunchTimeout(Duration.ofMillis(120000))  // ← Исправлено!
                .setAvdReadyTimeout(Duration.ofMillis(120000));

        try {
            return new AndroidDriver(new URL(config.serverUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium server URL", e);
        }
    }

}
