package geo.geopoints.services;

import geo.geopoints.models.Ggs;
import geo.geopoints.repositories.GgsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GgsService {
    private final GgsRepository ggsRepository;

    @Autowired
    public GgsService(GgsRepository ggsRepository) {
        this.ggsRepository = ggsRepository;
    }

    public void saveGgs(List<Ggs> points) {
        ggsRepository.saveAll(points);
    }

    public List<Ggs> findByCoordinates(double x, double y, double radius) {
        return ggsRepository.findAll().stream()
                .filter(a -> Math.abs(a.getCoordinates()[1] - x) <= 0.01 * radius
                        && Math.abs(a.getCoordinates()[0] - y) <= 0.01 * radius)
                .toList();
    }
}
