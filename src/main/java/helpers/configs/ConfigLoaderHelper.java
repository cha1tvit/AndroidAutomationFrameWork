package helpers.configs;

import org.aeonbits.owner.ConfigFactory;

public class ConfigLoaderHelper {
    public static final ProjectProperties PROJECT_PROPERTIES = ConfigFactory.create(ProjectProperties.class);
}
