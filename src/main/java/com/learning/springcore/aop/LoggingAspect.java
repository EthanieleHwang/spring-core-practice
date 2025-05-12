package com.learning.springcore.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {


    public LoggingAspect(){
        System.out.println("[Aspect Life cycle] LoggingAspect: Constructor called -Aspect Bean created");
    }

    //1.定义 一个Pointcut,命名为serviceLayerExecution
    //表达式匹配：com.learning.springcore.service包下的所有类的所有public方法
    @Pointcut("execution(public * com.learning.springcore.service.*.*(..))")
    public void serviceLayerExecution() {
        // Pointcut method, no implementation needed
    }

    //1.
    @Before("serviceLayerExecution()")
    public void logBeforeServiceCall(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("[Aop log - Before] Executing method: "+ methodName + "with arguments:" + args);

    }

    //2.
    @AfterReturning(pointcut = "serviceLayerExecution()",returning = "result")
    public void logAfterReturning(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[Aop log - AfterReturning] Method: " + methodName + "executed successfully and returned:"+result);

    }
    //3.
    @AfterThrowing(pointcut= "serviceLayerExecution()",throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint,Throwable exception ) {
        String methodName = joinPoint.getSignature().getName();
        System.err.println(" [AOP log - AfterThrowing] Exception in method: "+ methodName + ".Exception is" + exception.getMessage());
    }

    //4.
    @After("serviceLayerExecution()")
    public void logAfterServiceCompletion(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("[AOP Log - After] Method: " +methodName + "execution completed (either normally or with exception).");

    }
}
