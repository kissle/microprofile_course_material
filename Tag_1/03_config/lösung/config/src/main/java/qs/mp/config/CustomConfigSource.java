package qs.mp.config;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CustomConfigSource implements ConfigSource {

    private Map<String, String> properties = new HashMap<>();

    public CustomConfigSource() {
        properties.put("custom.greeting.message.heading", "CustomConfigSource Message");
        properties.put("custom.greeting.message.body", "Hello from CustomConfigSource!");
    }

    @Override
    public Map<String, String> getProperties() {
        return properties;
    }

    @Override
    public Set<String> getPropertyNames() {
        return properties.keySet();
    }

    @Override
    public int getOrdinal() {
        return 500;
    }

    @Override
    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public String getName() {
        return "CustomConfigSource";
    }
}
