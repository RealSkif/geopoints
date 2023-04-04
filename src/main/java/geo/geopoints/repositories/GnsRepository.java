package geo.geopoints.repositories;

import geo.geopoints.models.Gns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GnsRepository extends JpaRepository<Gns, Integer> {
    @Query("SELECT e FROM Gns e WHERE e.longitude <= :x + :r*0.01" +
            " AND e.longitude >= :x - :r*0.01 " +
            " AND e.latitude <= :y + :r*0.01 " +
            " AND e.latitude >= :y - :r*0.01 ")
    List<Gns> findByCoordinates(@Param("x") double x, @Param("y") double y, @Param("r") double r);

    List<Gns> findBymsk(String msk);
}