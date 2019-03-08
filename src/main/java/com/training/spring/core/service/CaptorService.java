package com.training.spring.core.service;

import com.training.spring.core.model.Captor;

import java.util.Set;

public interface CaptorService {
    Set<Captor> findBySite(String siteId);

}
