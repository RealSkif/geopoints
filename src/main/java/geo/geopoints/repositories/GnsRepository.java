package geo.geopoints.repositories;


import geo.geopoints.models.Gns;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GnsRepository extends JpaRepository<Gns, Integer> {
    List<Gns> findBymsk(String msk);
}