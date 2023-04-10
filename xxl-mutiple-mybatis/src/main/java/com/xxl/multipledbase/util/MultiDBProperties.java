package com.xxl.multipledbase.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import com.xxl.multipledbase.support.ConfKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiDBProperties {
    private static final Logger log = LoggerFactory.getLogger(MultiDBProperties.class);
    private static Properties properties;
    private static Properties defaultProperties = new Properties();

    private MultiDBProperties() {
    }

    public static void load() {
        try {
            properties = new Properties(defaultProperties);
            InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("unif.properties");
            if (stream != null) {
                properties.load(stream);
                stream.close();
            }
        } catch (Exception var1) {
            log.error("Read unif.properties error.", var1);
        }

    }

    public static boolean save() {
        boolean res = false;

        try {
            URL url = Thread.currentThread().getContextClassLoader().getResource("unif.properties");
            if (url != null) {
                properties.store(new FileOutputStream(new File(url.toURI())), (String)null);
                res = true;
            }
        } catch (Exception var2) {
            log.error("Write unif.properties error.", var2);
        }

        return res;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static Properties getDefaultProperties() {
        return defaultProperties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static String getProperty(ConfKey key) {
        return properties.getProperty(key.getKey(), key.getDefaultValue());
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public static int getPropertyForInteger(String key) {
        String value = getProperty(key);

        try {
            return Integer.parseInt(value);
        }  catch (Exception var3) {
            log.error("转换 \"" + value + "\" 为 int 过程发生错误，引发的 properties 属性为 " + key, var3);
            throw new IllegalArgumentException("转换 \"" + value + "\" 为 int 过程发生错误，引发的 properties 属性为 " + key);
        }
    }

    public static int getPropertyForInteger(ConfKey key) {
        return getPropertyForInteger(key.getKey(), key.getDefaultValue());
    }

    public static int getPropertyForInteger(String key, String defaultValue) {
        String value = getProperty(key, defaultValue);

        try {
            return Integer.parseInt(value);
        } catch (Exception var4) {
            log.error("转换 \"" + value + "\" 为 int 过程发生错误，引发的 properties 属性为 " + key, var4);
            throw new IllegalArgumentException("转换 \"" + value + "\" 为 int 过程发生错误，引发的 properties 属性为 " + key);
        }
    }

    public static boolean getPropertyForBoolean(ConfKey key) {
        return getPropertyForBoolean(key.getKey(), key.getDefaultValue());
    }

    public static boolean getPropertyForBoolean(String key, String defaultValue) {
        return Boolean.parseBoolean(getProperty(key, defaultValue));
    }

    static {
        load();
    }
}