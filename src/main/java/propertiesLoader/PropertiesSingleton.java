package propertiesLoader;

import lombok.Getter;
import java.util.Objects;
import java.util.Properties;

public class PropertiesSingleton {
    private static final PropertiesSingleton instance = new PropertiesSingleton();
    @Getter
    private final Properties properties;

    private PropertiesSingleton() {
        String site = System.getProperty("site");
        this.properties = new Properties();

        try {
            this.properties.load(Objects.requireNonNull(getClass().getClassLoader().
                    getResourceAsStream("properties/" + site + ".properties")));
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    public static PropertiesSingleton getInstance() {
        return instance;
    }
}
