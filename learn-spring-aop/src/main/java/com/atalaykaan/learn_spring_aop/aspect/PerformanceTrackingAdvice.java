package com.atalaykaan.learn_spring_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAdvice {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around("com.atalaykaan.learn_spring_aop.aspect.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        logger.info("Around Advice - In Method: {} - executed in: {}ms", proceedingJoinPoint, end - start);

        return returnValue;
    }
}
