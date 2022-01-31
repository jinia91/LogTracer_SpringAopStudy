package aop.logtracer;

import aop.logtracer.aop.AspectV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class LogtracerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogtracerApplication.class, args);
	}

}
