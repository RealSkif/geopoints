package geo.geopoints;

import geo.geopoints.gRpc.GeopointsServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@SpringBootApplication
@EnableWebMvc
public class GeopointsApplication {

    public static void main(String[] args) throws IOException {

        Server server = ServerBuilder.forPort(8082).addService(new GeopointsServiceImpl()).build();
        server.start();
        SpringApplication.run(GeopointsApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

