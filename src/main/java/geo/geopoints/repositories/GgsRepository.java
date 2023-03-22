package geo.geopoints.repositories;

import geo.geopoints.models.Ggs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GgsRepository extends JpaRepository<Ggs, Integer> {

//    public List<Ggs> findByNLessThanEqual(float [] N);
}
