package com.training.spring.core.config;

import com.training.spring.core.model.ApplicationInfo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Set;

@Configuration
@Profile("dev")
@PropertySource("classpath:application.properties")

public class BigCorpApplicationDevConfig {

    @Autowired
    private Environment environmentDev;

    @Bean
    public ApplicationInfo applicationInfoDev(){
        String name = environmentDev.getRequiredProperty("bigcorp.name");
        Integer version = environmentDev.getRequiredProperty("bigcorp.version", Integer.class);
        Set<String> emails = environmentDev.getRequiredProperty("bigcorp.emails", Set.class);
        String webSiteUrl = environmentDev.getRequiredProperty("bigcorp.webSiteUrl");

        return new ApplicationInfo(name, version, emails, webSiteUrl);
    }
}
