package util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeChecker {
    @Around("execution(* service.*Service.*(..))")
    public void timeCheck(ProceedingJoinPoint joinPoint) throws  Throwable{
        //실행 전
        long start = System.nanoTime();
        String name = joinPoint.getSignature().getName();

        joinPoint.proceed();

        //실행 후
        long end = System.nanoTime();
        System.out.println(name+"의 실행시간은 "+(end-start)+"ns 입니다.");
    }
}
