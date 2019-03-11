package com.training.spring.core.service;

import com.training.spring.core.model.Captor;
import com.training.spring.core.model.PowerSource;
import com.training.spring.core.model.Site;
import com.training.spring.core.utils.OutputCapture;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Set;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SiteServiceImplTest.SiteServiceTestConfiguration.class})

public class SiteServiceImplTest {
    @Configuration
    @ComponentScan("com.training.spring.core.service")
    static class SiteServiceTestConfiguration{}

    @Autowired
    private SiteService siteService;

    @Rule
    public OutputCapture output = new OutputCapture();

    @Test
    public  void readFileFromUrl(){
        siteService.readFile("url:https://dev-mind.fr/lorem.txt");
        Assertions.assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }
    @Test
    public void readFileFromClasspath(){
        siteService.readFile("classpath:lorem.txt");
        Assertions.assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }

    @Test
    public void readFileFromFileSystem(){
        siteService.readFile("file:///Users//Acer//Documents//workspace//formation-spring-tp-core//formation-spring-tp/loremFileSystem.txt");
        Assertions.assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }


    @Mock
    private CaptorService captorService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdShouldReturnNullWhenIdIsNull(){
        // Initialisation
        String siteId = null;

        // Appel du SUT
        Site site = siteService.findById(siteId);

        // Vérification
        Assertions.assertThat(site).isNull();
    }

    @Test
    public void findById(){
        // Initialisation
        String siteId = "siteId";
        Set<Captor> expectedCaptors = Collections.singleton(new Captor("Capteur A", PowerSource.SIMULATED));
        Mockito.when(captorService.findBySite(siteId)).thenReturn(expectedCaptors);

        // Appel du SUT
        Site site = siteService.findById(siteId);

        // Vérification
        Assertions.assertThat(site.getId()).isEqualTo(siteId);
        Assertions.assertThat(site.getName()).isEqualTo("Florange");
        Assertions.assertThat(site.getCaptors()).isEqualTo(expectedCaptors);
    }
}