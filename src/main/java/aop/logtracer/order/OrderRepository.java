package aop.logtracer.order;

import aop.logtracer.annotation.Trace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrderRepository {

    @Trace
    public String save(String itemId) {
        log.info("[orderRepository] 실행");
        if (itemId.equals("ex")) {
            throw new IllegalStateException("예외 발생!");
        }
        return "ok";
    }
}
