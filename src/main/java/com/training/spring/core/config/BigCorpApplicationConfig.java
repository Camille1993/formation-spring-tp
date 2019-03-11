package com.training.spring.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.training.spring.core")
@Configuration
@EnableAspectJAutoProxy
public class BigCorpApplicationConfig {


}
