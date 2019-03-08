package com.training.spring.core.service;

import com.training.spring.core.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {

    private CaptorService captorService;
    @Autowired
    public SiteServiceImpl(CaptorService captorService){
        System.out.println("Init SiteServiceImpl :" + this);
        this.captorService = captorService;
    }

    @Override
    public Site findById(String siteId) {
        System.out.println("Appel de findById:" +this);
        if (siteId == null) {
            return null;
        }

        Site site = new Site("Florange");
        site.setId(siteId);
        site.setCaptors(captorService.findBySite(siteId));
        return site;
    }



}
