package com.training.spring.core.config;

import com.training.spring.core.model.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import java.util.Set;

@Configuration
@Profile("prod")
@PropertySource("classpath:application-prod.properties")

public class BigCorpApplicationProdConfig {

    @Autowired
    private Environment environmentProd;


    @Bean
    public ApplicationInfo applicationInfoProd(){
        String name = environmentProd.getRequiredProperty("bigcorp.name");
        Integer version = environmentProd.getRequiredProperty("bigcorp.version", Integer.class);
        Set<String> emails = environmentProd.getRequiredProperty("bigcorp.emails", Set.class);
        String webSiteUrl = environmentProd.getRequiredProperty("bigcorp.webSiteUrl");

        return new ApplicationInfo(name, version, emails, webSiteUrl);
    }
}
