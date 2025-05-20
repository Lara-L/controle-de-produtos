package bd.trabalho.demo.application.swagger;

import static java.util.Collections.sort;

import bd.trabalho.demo.TrabalhoDeBdApplication;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Profile(value = {"dev", "staging"})
@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("API de Controle de Produtos")
            .version("1.0")
            .description("Documentação da API para o sistema de controle de produtos perecíveis."));
  }

}
