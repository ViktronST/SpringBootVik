package es.cursojava.springboot.springbootvik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})

public class SpringBootVikApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootVikApplication.class, args);
	}

}
