package config;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:config/real.properties")
public interface RealConfig extends Config {
    @Key("device.name")
    String deviceName();

    @Key("platform.version")
    String platformVersion();

    @Key("server.url")
    String serverUrl();

    @Key("app.path")
    String appPath();
}