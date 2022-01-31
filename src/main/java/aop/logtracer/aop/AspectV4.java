package aop.logtracer.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

/**
 * Aspect : Advisor
 * Around Annotation : PointCut - AspectJ PointCut Expression
 * doLog : Advice
 */
@Slf4j
public class AspectV4 {

    @Aspect
    @Order(1)
    public static class LogAspect{
        @Around("aop.logtracer.aop.PointCuts.allOrder()")
        public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
            log.info("[log] {}",joinPoint.getSignature());
            return joinPoint.proceed();
        }
    }

    @Aspect
    @Order(2)
    public static class TxAspect{
        @Around("aop.logtracer.aop.PointCuts.orderAndService()")
        public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable{
            try{
                log.info("[transaction start] {}",joinPoint.getSignature());
                Object result = joinPoint.proceed();
                log.info("[transaction commit] {}",joinPoint.getSignature());
                return result;}
            catch (Throwable t){
                log.info("[exception] {} 에서 {}",joinPoint.getSignature(),t.getMessage());
                log.info("[transaction rollback] {}",joinPoint.getSignature());
                throw t;
            }finally {
                log.info("[resource release] {}",joinPoint.getSignature());
            }
        }
    }
}
