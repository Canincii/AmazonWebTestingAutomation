package com.amazon.automation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Loads environment-specific configuration from classpath.
 * Environment is selected via -Denv system property (defaults to "qa").
 */
public final class ConfigReader {

    private static final Logger log = LoggerFactory.getLogger(ConfigReader.class);
    private static Properties properties;

    private ConfigReader() {
    }

    public static synchronized Properties getProperties() {
        if (properties == null) {
            properties = loadProperties();
        }
        return properties;
    }

    private static Properties loadProperties() {
        String env = System.getProperty("env", "qa");
        String path = "config/" + env + ".properties";
        log.info("Loading configuration for environment: {}", env);

        Properties props = new Properties();
        try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                throw new RuntimeException("Config file not found: " + path);
            }
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config: " + path, e);
        }
        return props;
    }

    public static String get(String key) {
        return getProperties().getProperty(key);
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(get(key));
    }
}
