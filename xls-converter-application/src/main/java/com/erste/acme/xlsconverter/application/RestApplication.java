package com.erste.acme.xlsconverter.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@ComponentScan({"com.erste.acme.xlsconverter"})
@EnableConfigurationProperties
public class RestApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RestApplication.class)
            .initializers((GenericApplicationContext context) -> context.setAllowBeanDefinitionOverriding(false))
            .run();
    }
}
