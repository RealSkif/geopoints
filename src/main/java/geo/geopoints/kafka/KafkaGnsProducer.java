package geo.geopoints.kafka;

import geo.geopoints.models.Ggs;
import geo.geopoints.models.Gns;
import geo.geopoints.services.GgsService;
import geo.geopoints.services.GnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaGnsProducer {
    private final KafkaTemplate<String, Gns> gnsKafkaTemplate;
    private final GnsService gnsService;

    @Autowired
    public KafkaGnsProducer(KafkaTemplate<String, Gns> gnsKafkaTemplate, GnsService gnsService) {
        this.gnsKafkaTemplate = gnsKafkaTemplate;
        this.gnsService = gnsService;
    }


    public void sendGns(double latitude, double longitude,
                        double radius) {
        List<Gns> gnsList = gnsService.findByCoordinates(latitude, longitude, radius);
        Message<List<Gns>> message = MessageBuilder.withPayload(gnsList)
                .setHeader(KafkaHeaders.TOPIC, "gns")
                .build();
        gnsKafkaTemplate.send(message);
    }
}
