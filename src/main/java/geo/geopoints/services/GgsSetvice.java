package geo.geopoints.services;

import geo.geopoints.models.Ggs;
import geo.geopoints.repositories.GgsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GgsSetvice {
    private final GgsRepository ggsRepository;

    @Autowired
    public GgsSetvice(GgsRepository ggsRepository) {
        this.ggsRepository = ggsRepository;
    }
//    @Query("SELECT u FROM ggs u WHERE (u.coordinates[0] - 1 < 15)")
    public List<Ggs> listOfGgs(float [] coordinates) {
        float x = coordinates[0];
        float y = coordinates[1];
        return ggsRepository.findAll().stream()
                .filter(a -> a.getCoordinates()[0] - x <=0.15 &&a.getCoordinates()[1] - y <=0.15 ).toList();
    }
}
