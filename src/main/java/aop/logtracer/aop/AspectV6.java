package aop.logtracer.aop;

import aop.logtracer.aop.logTracer.LogTracer;
import aop.logtracer.aop.logTracer.TraceStatus;
import lombok.RequiredArgsConstructor;
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
public class AspectV6 {

    @Aspect
    @Order(2)
    @RequiredArgsConstructor
    public static class LogAspect {

        private final LogTracer logTracer;

        @Around("@annotation(aop.logtracer.annotation.Trace)")
        public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable {
            TraceStatus status = null;
            boolean hasException = false;
            try {
                status = logTracer.begin(joinPoint.getSignature().toString());
                return joinPoint.proceed();
            } catch (Exception ex) {
                logTracer.exception(status, ex);
                hasException = true;
                throw ex;
            } finally {
                if(!hasException) logTracer.end(status);
            }
        }
    }

    @Aspect
    @Order(1)
    public static class TxAspect {
        @Around("aop.logtracer.aop.PointCuts.orderAndService()")
        public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
            try {
                log.info("[transaction start] {}", joinPoint.getSignature());
                Object result = joinPoint.proceed();
                log.info("[transaction commit] {}", joinPoint.getSignature());
                return result;
            } catch (Throwable t) {
                log.info("[exception] {} 에서 {}", joinPoint.getSignature(), t.getMessage());
                log.info("[transaction rollback] {}", joinPoint.getSignature());
                throw t;
            } finally {
                log.info("[resource release] {}", joinPoint.getSignature());
            }
        }
    }
}
