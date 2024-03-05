package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Aspect
@Configuration
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))") //want to get all methods from CourseController
//    private void pointcut(){
//    }
//    @Before("pointcut()")
//    public void log(){
//        logger.info("Logger info -----");
//    }
//
//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void beforeAdvice(){
//        logger.info("Logger info --------");
//    }

//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
//    public void anyProductRepositoryFindById(){}
//
//    @Before("anyProductRepositoryFindById()")
//    public void beforeCourseRepoOperation(JoinPoint joinPoint){
//        logger.info("Before (findById) -> Method:{} -Arguments:{} - Target: {}", joinPoint, joinPoint.getArgs(),joinPoint.getTarget());
//    }

//    @Pointcut("within(com.cydeo.controller..*)")
//    private void anyControllerOperation(){}
//
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    private void anyServiceOperation(){
//
//    }
//
//    @Before("anyControllerOperation() || anyServiceOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before () -> Method: {} - Arguments :{} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    private void anyDeleteCourseOperation(){}
//
//    @Before("anyDeleteCourseOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before () -> Method: {} - Arguments :{} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    private void anyDeleteCourseOperation(){}
//
//    @Before("anyDeleteCourseOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before () -> Method: {} - Arguments :{} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
//    }
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetCourseOperation(){}

//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint, Object result ){
//        logger.info("After returning(List) -> Method:{} - result{}", joinPoint.getSignature().toShortString(),result.toString());
//    }
//    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
//    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> result ){
//        logger.info("After returning(List) -> Method:{} - result{}", joinPoint.getSignature().toShortString(),result.toString());
//    }

    @AfterThrowing(pointcut = "anyGetCourseOpeartion()", throwing = "exception")
    public void
}
