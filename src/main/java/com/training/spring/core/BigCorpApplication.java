package com.training.spring.core;

import com.training.spring.core.config.BigCorpApplicationConfig;

import com.training.spring.core.model.ApplicationInfo;
import com.training.spring.core.service.SiteService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BigCorpApplication {


    public static void main (String[] args){
        BigCorpApplication application = new BigCorpApplication();
        application.run();
    }

    public void run(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BigCorpApplicationConfig.class);
        context.refresh();
        ApplicationInfo applicationInfo = context.getBean(ApplicationInfo.class);


        System.out.println("=============================================================");
        System.out.println("Application [" + applicationInfo.getName() +"] - version : " + applicationInfo.getVersion());
        System.out.println("plus d'information sur " + applicationInfo.getWebSiteUrl());
        System.out.println("=============================================================");

        SiteService siteService =context.getBean(SiteService.class);
        System.out.println(siteService.findById("siteA")+"\n");

        siteService.readFile("classpath:lorem.txt");

    }
}
