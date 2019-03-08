package com.training.spring.core;

import com.training.spring.core.service.CaptorService;
import com.training.spring.core.service.CaptorServiceImpl;
import com.training.spring.core.service.SiteService;
import com.training.spring.core.service.SiteServiceImpl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan
@Configuration
public class BigCorpApplicationConfig {


    public SiteService siteService(){
        return new SiteServiceImpl(captorService());
    }

    public CaptorService captorService(){
        return new CaptorServiceImpl();
    }
}
