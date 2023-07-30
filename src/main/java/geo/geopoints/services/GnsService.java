package geo.geopoints.services;


import geo.geopoints.models.Gns;
import geo.geopoints.repositories.GnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class GnsService {
    private final GnsRepository gnsRepository;

    @Autowired
    public GnsService(GnsRepository gnsRepository) {
        this.gnsRepository = gnsRepository;
    }

    public List<Gns> findBymsk(String msk) {
        return gnsRepository.findBymsk(msk);
    }

    public List<Gns> findByCoordinates(double x, double y, double radius) {
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

        return gnsRepository.findByCoordinates(eastX, westX, northY, southY);
    }
}
