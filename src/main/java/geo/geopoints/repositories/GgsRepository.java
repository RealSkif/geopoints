package geo.geopoints.repositories;

import geo.geopoints.models.Ggs;
import geo.geopoints.models.Gns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GgsRepository extends JpaRepository<Ggs, Integer> {
    List<Ggs> findByregions(String regionsRef);
    List<Ggs> findBymsk(String msk);

}
