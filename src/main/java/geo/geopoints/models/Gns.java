package geo.geopoints.models;

import jakarta.persistence.*;

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
    private String maingeographyfeature;
    @Column(name = "msk")
    private String msk;
    @Column(name = "regions_ref")
    private String regions_ref;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

    public Gns() {
    }

    public Gns(String name, String index, String mark, String sighType, String centerType,
               String maingeographyfeature, String msk, String regions_ref, double latitude, double longitude) {
        this.name = name;
        this.index = index;
        this.mark = mark;
        this.sighType = sighType;
        this.centerType = centerType;
        this.maingeographyfeature = maingeographyfeature;
        this.msk = msk;
        this.regions_ref = regions_ref;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSighType() {
        return sighType;
    }

    public void setSighType(String sighType) {
        this.sighType = sighType;
    }

    public String getCenterType() {
        return centerType;
    }

    public void setCenterType(String centerType) {
        this.centerType = centerType;
    }

    public String getMaingeographyfeature() {
        return maingeographyfeature;
    }

    public void setMaingeographyfeature(String maingeographyfeature) {
        this.maingeographyfeature = maingeographyfeature;
    }

    public String getMsk() {
        return msk;
    }

    public void setMsk(String msk) {
        this.msk = msk;
    }

    public String getRegions_ref() {
        return regions_ref;
    }

    public void setRegions_ref(String regions_ref) {
        this.regions_ref = regions_ref;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

