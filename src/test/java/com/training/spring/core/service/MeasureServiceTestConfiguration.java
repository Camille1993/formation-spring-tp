package com.training.spring.core.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.training.spring.core.service.measure")
@PropertySource("classpath:application.properties")
public class MeasureServiceTestConfiguration{}
