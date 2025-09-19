package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/mobile.properties"})
public interface MobileConfig extends Config {
    @Key("browserstack.user")
    String bsUser();

    @Key("browserstack.key")
    String bsKey();

    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("platformVersion")
    String osVersion();

    @Key("app")
    String app();

    @Key("projectName")
    String projectName();

    @Key("buildName")
    String buildName();

    @Key("sessionName")
    String sessionName();

}
