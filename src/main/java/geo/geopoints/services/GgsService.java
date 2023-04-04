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

    public void saveGgs(List<Ggs> points) {
        ggsRepository.saveAll(points);
    }

    public List<Ggs> findByRegions_ref(String ref) {
        return ggsRepository.findByregions(ref);
    }

    public List<Ggs> findBymsk(String msk) {
        return ggsRepository.findBymsk(msk);
    }


    public List<Ggs> findByCoordinates(float x, float y, float radius) {
        return ggsRepository.findByCoordinates(x, y, radius);
    }
}
