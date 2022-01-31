package aop.logtracer.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut("execution(* aop.logtracer.order..*(..))")
    public void allOrder(){}   // pointcut signature

    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}   // pointcut signature

    @Pointcut("allOrder() && allService()")
    public void orderAndService(){}   // pointcut signature
}
