package geo.geopoints;

import geo.geopoints.gRpc.GeopointsServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@SpringBootApplication
@EnableWebMvc
public class GeopointsApplication {
    public static void main(String[] args)  {
        SpringApplication.run(GeopointsApplication.class, args);
    }
    @Bean
    public Server grpcServer(GeopointsServiceImpl geopointsService) throws IOException {
        Server server = ServerBuilder.forPort(8082)
                .addService(geopointsService)
                .build();
        server.start();
        return server;
    }
}

