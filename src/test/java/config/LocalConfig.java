package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${device}.properties"
})
public interface LocalConfig extends Config {

    @Key("platformVersion")
    String getPlatformVersion();

    @Key("deviceName")
    String getDeviceName();
}
