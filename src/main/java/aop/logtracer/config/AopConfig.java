package aop.logtracer.config;

import aop.logtracer.aop.AspectV4;
import aop.logtracer.aop.AspectV5;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfig {

    @Bean
    public AspectV5.LogAspect aspectLogBean(){
        return new AspectV5.LogAspect();
    }

    @Bean
    public AspectV5.TxAspect aspectTxBean(){
        return new AspectV5.TxAspect();
    }

}
