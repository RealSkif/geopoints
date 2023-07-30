package geo.geopoints.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI geopointsOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Geopoints")
                        .description("API для сервиса geopoints")
                        .version("1.0"));
    }
}