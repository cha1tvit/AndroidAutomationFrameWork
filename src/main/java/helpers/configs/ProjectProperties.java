package helpers.configs;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources(value="file:${user.dir}/src/main/resources/config/project.properties")
public interface ProjectProperties extends Config {

    @Config.Key("app.apk.local.path")
    String apkLocalPath();

    @Config.Key("app.apk.remote.path")
    String apkRemotePath();

    @Config.Key("appium.localhost")
    String appiumLocalHost();

    @Config.Key("appium.remote.host")
    String appiumRemoteHost();
}
