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
public class GgsService {
    private final GgsRepository ggsRepository;

    @Autowired
    public GgsService(GgsRepository ggsRepository) {
        this.ggsRepository = ggsRepository;
    }
    public void saveGgs(List<Ggs> points){
        ggsRepository.saveAll(points);
    }

    public List<Ggs> listOfGgs(String stringX, String stringY) {
        double x = Double.parseDouble(stringX);
        double y = Double.parseDouble(stringY);
        return ggsRepository.findAll().stream()
                .filter(a -> a.getCoordinates()[1] - x <=0.15 &&a.getCoordinates()[0] - y <=0.15 ).toList();
    }
}
