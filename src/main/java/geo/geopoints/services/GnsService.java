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

    public void saveGns(List<Gns> points) {
        gnsRepository.saveAll(points);
    }

    public List<Gns> findBymsk(String msk) {
        return gnsRepository.findBymsk(msk);
    }

    public List<Gns> findByCoordinates(double x, double y, double radius) {
        return gnsRepository.findByCoordinates(x, y, radius);
    }
}
