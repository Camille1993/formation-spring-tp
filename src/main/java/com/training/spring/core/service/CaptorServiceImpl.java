package com.training.spring.core.service;

import com.training.spring.core.model.Captor;
import com.training.spring.core.model.PowerSource;
import com.training.spring.core.service.measure.MeasureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class CaptorServiceImpl implements CaptorService {

    @Autowired
    private MeasureService fixedMeasureService;
    @Autowired
    private MeasureService realMeasureService;
    @Autowired
    private MeasureService simulatedMeasureService;

    public void setFixedMeasureService(MeasureService fixedMeasureService) {
        this.fixedMeasureService = fixedMeasureService;
    }

    public void setRealMeasureService(MeasureService realMeasureService){
        this.realMeasureService =realMeasureService;
    }

    public void setSimulatedMeasureService(MeasureService simulatedMeasureService) {
        this.simulatedMeasureService = simulatedMeasureService;
    }

        @Override
    public Set<Captor> findBySite(String siteId) {
        Set<Captor> captors = new HashSet<>();
        if (siteId == null) {
            return captors;
        }
        captors.add(new Captor("Capteur A", PowerSource.FIXED));
        captors.add(new Captor("Capteur A", PowerSource.REAL));
        captors.add(new Captor("Capteur A", PowerSource.SIMULATED));
        return captors;
    }

}
