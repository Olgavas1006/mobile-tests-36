package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;

public class DriverFactory {
    public static WebDriverProvider createDriver(String deviceHost) {
        switch (deviceHost.toLowerCase()) {
            case "browserstack":
                return new BrowserstackDriver();
            case "real":
                return new RealDeviceDriver();
            case "emulation":
            default:
                return new EmulationDriver();
        }
    }
}
