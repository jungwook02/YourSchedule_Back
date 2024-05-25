package ys.mp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MpApplication {

	public static void main(String[] args) {
		SpringApplication.run(MpApplication.class, args);
	}

}
