package geo.geopoints.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "gns")
public class Gns {
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
    @Column(name = "maingeographyfeature")
    private String mainGeographyFeature;
    @Column(name = "msk")
    private String msk;
    @Column(name = "regions_ref")
    private String regions_ref;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

}

