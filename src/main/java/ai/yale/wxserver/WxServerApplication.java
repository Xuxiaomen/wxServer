package ai.yale.wxserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WxServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxServerApplication.class, args);
	}
}
