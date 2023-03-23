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

    public List<Ggs> listOfGgs(double [] coordinates) {
        double x = coordinates[0];
        double y = coordinates[1];
        return ggsRepository.findAll().stream()
                .filter(a -> a.getCoordinates()[1] - x <=10.15 &&a.getCoordinates()[0] - y <=10.15 ).toList();
    }
}
