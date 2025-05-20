package bd.trabalho.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@SpringBootApplication
public class TrabalhoDeBdApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhoDeBdApplication.class, args);
	}

}


