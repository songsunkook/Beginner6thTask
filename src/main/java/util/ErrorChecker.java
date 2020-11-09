package util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorChecker {
    @AfterThrowing(pointcut = "execution(* service.*Service.*(..))", throwing = "exception")
    public void checkError(JoinPoint joinPoint, Throwable exception) throws Exception{
        // method의 경로 ex) service.SearchServiceImpl.~method
        String methodCourse = joinPoint.getSignature().toString();
        String methodName = joinPoint.getSignature().getName();
        String errorMessage = exception.toString();

        System.out.println(
                methodName + "에서 오류가 발생했습니다!\n"
                        + "경로 : " + methodCourse + "\n"
                        + "에러 메시지 : " + errorMessage
        );
    }
}
