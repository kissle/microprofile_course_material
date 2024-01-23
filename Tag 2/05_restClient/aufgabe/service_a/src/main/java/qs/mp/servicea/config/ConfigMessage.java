package qs.mp.servicea.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "greeting.message")
public interface ConfigMessage{

    String heading();
    String body();
}
