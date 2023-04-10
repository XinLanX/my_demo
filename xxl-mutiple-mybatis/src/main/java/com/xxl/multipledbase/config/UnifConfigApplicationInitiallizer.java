package com.xxl.multipledbase.config;


import com.xxl.multipledbase.util.MultiDBProperties;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

@Configuration
public class UnifConfigApplicationInitiallizer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
    public UnifConfigApplicationInitiallizer(){

    }

    public void initialize(ConfigurableApplicationContext context) {
        ConfigurableEnvironment env = context.getEnvironment();
        this.addPropertyToUnifProperties(env);
    }

    public int getOrder() {
        return -2147483631;
    }

    private void addPropertyToUnifProperties(ConfigurableEnvironment env) {
        Iterator var2 = env.getPropertySources().iterator();

        while(true) {
            PropertySource source;
            do {
                if (!var2.hasNext()) {
                    return;
                }

                source = (PropertySource)var2.next();
            } while(!(source instanceof EnumerablePropertySource));

            EnumerablePropertySource<?> enumerable = (EnumerablePropertySource)source;
            String[] var5 = enumerable.getPropertyNames();
            int var6 = var5.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                String name = var5[var7];
                MultiDBProperties.setProperty(name, enumerable.getProperty(name).toString());
            }
        }
    }
}
