package com.training.spring.core.service;

import com.training.spring.core.config.Monitored;
import com.training.spring.core.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

@Service
public class SiteServiceImpl implements SiteService {

    private CaptorService captorService;
    @Autowired
    public SiteServiceImpl(CaptorService captorService){
        System.out.println("Init SiteServiceImpl :" + this);
        this.captorService = captorService;
    }
    @Monitored
    @Override
    public Site findById(String siteId) {
        Site site = new Site("Florange");
        site.setId(siteId);
        site.setCaptors(captorService.findBySite(siteId));
        return site;
    }

    @Autowired
    private ResourceLoader resourceLoader;

    public void readFile(String path){
        Resource resource = resourceLoader.getResource(path);

        try (InputStream stream = resource.getInputStream()){
            Scanner scanner = new Scanner(stream).useDelimiter("\\n");
            while (scanner.hasNext()){
                System.out.println(scanner.next());
            }
        }catch (IOException e){
            e.printStackTrace();
        }}
}
