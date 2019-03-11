package com.training.spring.core.service;

import com.training.spring.core.model.Captor;
import com.training.spring.core.model.Measure;
import com.training.spring.core.model.MeasureStep;
import com.training.spring.core.service.measure.MeasureService;

import java.time.Instant;
import java.util.Set;

public interface CaptorService {
    Set<Captor> findBySite(String siteId);


}
