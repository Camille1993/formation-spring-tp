package com.training.spring.core.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitoredAspect {
    @Before("@annotation(Monitored)")
    public void logServiceBeforeCall(JoinPoint jp){
        System.out.println("Appel finder "+jp.getSignature());
    }
    @AfterReturning(pointcut = "@annotation(Monitored)", returning = "element")
    public void logServiceAfterCall(JoinPoint jp, Object element){
        if(element ==null){
            System.out.println("\n"+"Finder " + jp.getTarget()+ "returns null");
        }else {
            System.out.println("\n"+"Finder " +jp.getTarget()+ "returns" + element.toString());
        }
    }
}
