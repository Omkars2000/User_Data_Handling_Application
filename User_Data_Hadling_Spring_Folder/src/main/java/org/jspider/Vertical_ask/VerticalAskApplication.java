package org.jspider.Vertical_ask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebConfig.class)
public class VerticalAskApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerticalAskApplication.class, args);
	}

}
