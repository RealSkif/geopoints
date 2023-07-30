package geo.geopoints.repositories;

import geo.geopoints.models.Ggs;
import geo.geopoints.models.Gns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GnsRepository extends JpaRepository<Gns, Integer> {
    @Query("SELECT e FROM Gns e WHERE e.longitude <= :eastX" +
            " AND e.longitude >= :westX " +
            " AND e.latitude <= :northY " +
            " AND e.latitude >= :southY ")
    List<Gns> findByCoordinates(@Param("eastX") double eastX, @Param("westX") double westX,
                                @Param("northY") double northY, @Param("southY") double southY);

    List<Gns> findBymsk(String msk);
}