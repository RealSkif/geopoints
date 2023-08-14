package geo.geopoints.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ggs")
public class Ggs {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "index")
    private String index;
    @Column(name = "mark")
    private String mark;
    @Column(name = "sightype")
    private String sighType;
    @Column(name = "centertype")
    private String centerType;
    @Column(name = "msk")
    private String msk;
    @Column(name = "regions_ref")
    private String regions;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

}
