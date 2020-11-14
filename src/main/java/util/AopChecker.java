package util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Aspect
@Component
public class AopChecker {

    @Before("execution(* service.AopServiceImpl.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("===Before===");
        System.out.println("전달된 메서드명 : " + joinPoint.getSignature().getName());
        System.out.println("============");
    }
    @Around("execution(* service.AopServiceImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("===Around===");
        System.out.println("전달된 메서드 : " + joinPoint.getSignature().toShortString());
        System.out.println("============");
        Object temp = joinPoint.proceed();
        return temp;
    }
    @After("execution(* service.AopServiceImpl.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("===After===");
        System.out.println("전달된 메서드 : " + joinPoint.getSignature().toShortString());
        System.out.println("===========");
    }
    @AfterReturning(value = "execution(* service.AopServiceImpl.*(..))", returning = "ret")
    public void afterReturningMethod(JoinPoint joinPoint, String ret){
        System.out.println("===AfterReturning===");
        System.out.println("전달된 메서드 : " + joinPoint.getSignature().toShortString());
        System.out.println("리턴값 : " + ret);
        System.out.println("====================");
    }
    @AfterThrowing(value = "execution(* service.AopServiceImpl.*(..))", throwing = "thr")
    public void afterThrowingMethod(JoinPoint joinPoint, SQLException thr){
        System.out.println("===AfterThrowing===");
        System.out.println("전달된 메서드 : " + joinPoint.getSignature().toShortString());
        System.out.println("에러명 : " + thr);
        System.out.println("===================");
    }
}
