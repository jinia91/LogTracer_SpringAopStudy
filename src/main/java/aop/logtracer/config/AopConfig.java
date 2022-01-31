package aop.logtracer.config;

import aop.logtracer.aop.AspectV4;
import aop.logtracer.aop.AspectV5;
import aop.logtracer.aop.AspectV6;
import aop.logtracer.aop.logTracer.LogTracer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AopConfig {

    private final LogTracer logTracer;

    @Bean
    public AspectV6.LogAspect aspectLogBean(){
        return new AspectV6.LogAspect(logTracer);
    }

    @Bean
    public AspectV6.TxAspect aspectTxBean(){
        return new AspectV6.TxAspect();
    }

}
