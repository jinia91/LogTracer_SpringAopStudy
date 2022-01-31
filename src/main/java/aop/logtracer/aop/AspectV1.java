package aop.logtracer.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Aspect : Advisor
 * Around Annotation : PointCut - AspectJ PointCut Expression
 * doLog : Advice
 */
@Slf4j
@Aspect
public class AspectV1 {

    @Around("execution(* aop.logtracer.order..*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
      log.info("[log] {}",joinPoint.getSignature());
      return joinPoint.proceed();
    }
}
