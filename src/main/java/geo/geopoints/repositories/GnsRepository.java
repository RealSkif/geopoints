package geo.geopoints.repositories;

import geo.geopoints.models.Gns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GnsRepository extends JpaRepository<Gns, Integer> {
}