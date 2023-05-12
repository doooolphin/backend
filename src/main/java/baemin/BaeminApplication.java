package baemin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@EnableAspectJAutoProxy
@SpringBootApplication
public class BaeminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaeminApplication.class, args);
	}

}
