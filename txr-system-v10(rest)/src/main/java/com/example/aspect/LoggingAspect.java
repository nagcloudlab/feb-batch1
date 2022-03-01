package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@Component
@Aspect
public class LoggingAspect {

//    @Before(value = "execution(* com.example.service.TransferService+.*(..))")
//    public void doLogBefore(JoinPoint joinPoint){
//        log.info("before - {} - {} ",joinPoint.toShortString(), Arrays.stream(joinPoint.getArgs()).collect(Collectors.toList()));
//    }
//    @AfterReturning(value = "execution(* com.example.service.TransferService+.*(..))",returning = "r")
//    public void doLogAfterReturning(JoinPoint joinPoint,Object r){
//        log.info("after-returning - {} ",joinPoint.toShortString());
//    }
//    @AfterThrowing(value = "execution(* com.example.service.TransferService+.*(..))",throwing = "e")
//    public void doLogAfterThrowing(JoinPoint joinPoint,Throwable e){
//        log.info("after-throwing - {} {}",joinPoint.toShortString(),e.getMessage());
//    }
//    @After(value = "execution(* com.example.service.TransferService+.*(..))")
//    public void doLogAfter(JoinPoint joinPoint){
//        log.info("after - {}",joinPoint.toShortString());
//    }

    @Around(value = "execution(* com.example.service.TransferService+.*(..))")
    public void doLogBefore(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("before - {} - {} ", joinPoint.toShortString(), Arrays.stream(joinPoint.getArgs()).collect(Collectors.toList()));
            joinPoint.proceed();
            log.info("after-returning - {} ", joinPoint.toShortString());
        } catch (Throwable e) {
            log.info("after-throwing - {} {}", joinPoint.toShortString(), e.getMessage());
            throw e;
        } finally {
            log.info("after - {}", joinPoint.toShortString());
        }

    }

}
