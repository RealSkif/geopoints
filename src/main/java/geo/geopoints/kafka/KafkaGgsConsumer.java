package geo.geopoints.kafka;

import geo.geopoints.util.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaGgsConsumer {
    private final KafkaGgsProducer kafkaGgsProducer;

    @Autowired
    public KafkaGgsConsumer(KafkaGgsProducer kafkaGgsProducer) {
        this.kafkaGgsProducer = kafkaGgsProducer;
    }

    @KafkaListener(topics = "ggsRequest", groupId = "geopoints")
    private void consume(Request request) {
//        System.out.println("Широта из реквеста - "+request.getLatitude());
        kafkaGgsProducer.sendGgs(request.getLatitude(), request.getLongitude(),
                request.getRadius());
    }
}
