package geo.geopoints.services;

import geo.geopoints.models.Ggs;
import geo.geopoints.models.Gns;
import geo.geopoints.repositories.GgsRepository;
import geo.geopoints.repositories.GnsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Gns> findByCoordinates(double x, double y, double radius) {
        return gnsRepository.findAll().stream()
                .filter(a -> Math.abs(a.getCoordinates()[1] - x) <= 0.01 * radius
                        && Math.abs(a.getCoordinates()[0] - y) <= 00.01 * radius)
                .toList();
    }
}
