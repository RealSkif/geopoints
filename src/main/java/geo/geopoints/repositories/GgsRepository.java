package geo.geopoints.repositories;

import geo.geopoints.models.Ggs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GgsRepository extends JpaRepository<Ggs, Integer> {

    @Query("SELECT e FROM Ggs e WHERE e.longitude <= :eastX" +
            " AND e.longitude >= :westX " +
            " AND e.latitude <= :northY " +
            " AND e.latitude >= :southY ")
    List<Ggs> findByCoordinates(@Param("eastX") double eastX, @Param("westX") double westX,
                                @Param("northY") double northY, @Param("southY") double southY);

    List<Ggs> findBymsk(String msk);

}
