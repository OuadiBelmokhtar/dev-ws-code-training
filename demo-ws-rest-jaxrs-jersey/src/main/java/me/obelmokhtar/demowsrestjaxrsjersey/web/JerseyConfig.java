package me.obelmokhtar.demowsrestjaxrsjersey.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig {

    @Bean
    ResourceConfig resourceConfig() {
        ResourceConfig jerseyConfig = new ResourceConfig();
        jerseyConfig.register(CompteRestJaxRsJersey.class);
        return jerseyConfig;
    }
}
