package geo.geopoints.repositories;

import geo.geopoints.models.Ggs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GgsRepository extends JpaRepository<Ggs, Integer> {

    @Query("SELECT e FROM Ggs e WHERE e.longitude <= :x + :r*0.01" +
            " AND e.longitude >= :x - :r*0.01 " +
            " AND e.latitude <= :y + :r*0.01 " +
            " AND e.latitude >= :y - :r*0.01 ")
    List<Ggs> findByCoordinates(@Param("x") double x, @Param("y") double y,  @Param("r") double r);

    List<Ggs> findByregions(String regionsRef);
    List<Ggs> findBymsk(String msk);

}
