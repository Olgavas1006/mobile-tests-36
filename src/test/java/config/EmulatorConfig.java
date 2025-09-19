package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/emulator.properties")
public interface EmulatorConfig extends Config {
    @Key("device.name")
    String deviceName();

    @Key("platform.version")
    String platformVersion();

    @Key("server.url")
    String serverUrl();

}
