package mobile.mobileprogrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MobileProgrmApplication{

	public static void main(String[] args) {
		SpringApplication.run(MobileProgrmApplication.class, args);
	}

}
