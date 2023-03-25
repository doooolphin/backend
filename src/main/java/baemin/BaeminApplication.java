package baemin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class BaeminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaeminApplication.class, args);
	}

}
