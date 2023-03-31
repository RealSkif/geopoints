package geo.geopoints;

import geo.geopoints.dto.GgsDTO;
import geo.geopoints.dto.GnsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeopointsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeopointsApplication.class, args);
    }

    @Bean
    public GgsDTO ggsDTO() {
        return new GgsDTO();
    }
 @Bean
    public GnsDTO gnsDTO() {
        return new GnsDTO();
    }
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

