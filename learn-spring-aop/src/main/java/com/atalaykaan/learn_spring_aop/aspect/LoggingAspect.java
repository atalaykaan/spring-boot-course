package com.atalaykaan.learn_spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("com.atalaykaan.learn_spring_aop.aspect.CommonPointcutConfig.allPackageConfigUsingBean()")
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {

        logger.info("Before Aspect - In method: {} - with args: {}", joinPoint, joinPoint.getArgs());
    }

    @After("com.atalaykaan.learn_spring_aop.aspect.CommonPointcutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {

        logger.info("After Aspect - In method: {} - with args: {}", joinPoint, joinPoint.getArgs());
    }

    @AfterThrowing(
            pointcut = "com.atalaykaan.learn_spring_aop.aspect.CommonPointcutConfig.businessAndDataPackageConfig()",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {

        logger.info("AfterThrowing Aspect - In method: {} - thrown exception: {}",
                joinPoint, exception.getMessage());
    }

    @AfterReturning(
            pointcut = "com.atalaykaan.learn_spring_aop.aspect.CommonPointcutConfig.dataPackageConfig()",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {

        logger.info("AfterReturning - In method: {} - has returned: {}", joinPoint, resultValue);
    }
}
