package geo.geopoints.kafka;

import geo.geopoints.util.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaGnsConsumer {
    private final KafkaGnsProducer kafkaGnsProducer;

    @Autowired
    public KafkaGnsConsumer(KafkaGnsProducer kafkaGnsProducer) {
        this.kafkaGnsProducer = kafkaGnsProducer;
    }

    @KafkaListener(topics = "gnsRequest", groupId = "geopoints")
    private void consume(Request request) {
        System.out.println("gns request");
        kafkaGnsProducer.sendGns(request.getLatitude(), request.getLongitude(),
                request.getRadius());
    }
}
