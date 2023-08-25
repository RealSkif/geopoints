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
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class KafkaGgsProducer {

    private final KafkaTemplate<String, Ggs> ggsKafkaTemplate;
    private final GgsService ggsService;

    @Autowired
    public KafkaGgsProducer(KafkaTemplate<String, Ggs> ggsKafkaTemplate, GgsService ggsService) {
        this.ggsKafkaTemplate = ggsKafkaTemplate;
        this.ggsService = ggsService;
    }

    public void sendGgs(double latitude, double longitude,
                        double radius) {
        List<Ggs> ggsList = ggsService.findByCoordinates(latitude, longitude, radius);
        Message<List<Ggs>> message = MessageBuilder.withPayload(ggsList)
                .setHeader(KafkaHeaders.TOPIC, "ggs")
                .build();
        ggsKafkaTemplate.send(message);
    }
}
