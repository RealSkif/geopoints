package geo.geopoints.services;

import geo.geopoints.models.Ggs;
import geo.geopoints.repositories.GgsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class GgsService {
    private final GgsRepository ggsRepository;

    @Autowired
    public GgsService(GgsRepository ggsRepository) {
        this.ggsRepository = ggsRepository;
    }

    public List<Ggs> findBymsk(String msk) {
        return ggsRepository.findBymsk(msk);
    }

    public List<Ggs> findByCoordinates(double x, double y, double radius) {
        /*
         * Приблизительные значения в градусах для 1 км для долгот и широт соответственно.
         * Для разных широт значение latitudeDegree меняется, поэтому используется усредненное
         * */
        double longitudeDegree = 0.01;
        double latitudeDegree = 0.02;

        double eastX = x + radius * longitudeDegree;
        double westX = x - radius * longitudeDegree;
        double northY = y + radius * latitudeDegree;
        double southY = y - radius * latitudeDegree;

        return ggsRepository.findByCoordinates(eastX, westX, northY, southY);
    }
}
