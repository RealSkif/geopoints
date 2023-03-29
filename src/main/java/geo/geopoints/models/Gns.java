package geo.geopoints.models;

import jakarta.persistence.*;

@Entity
@Table(name = "gns")
public class Gns {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "index")
    String index;
    @Column(name = "mark")
    String mark;
    @Column(name = "sightype")
    String sighType;
    @Column(name = "centertype")
    String centerType;
    @Column(name = "maingeographyfeature")
    String maingeographyfeature;
    @Column(name = "msk")
    String msk;
    @Column(name = "regions_ref")
    String regions_ref;
    @Column(name = "coordinates")
    double[] coordinates;


    public Gns() {
    }

    public Gns(String name, String index, String mark, String sighType, String centerType,
               String maingeographyfeature, String msk, String regions_ref, double[] coordinates) {
        this.name = name;
        this.index = index;
        this.mark = mark;
        this.sighType = sighType;
        this.centerType = centerType;
        this.maingeographyfeature = maingeographyfeature;
        this.msk = msk;
        this.regions_ref = regions_ref;
        this.coordinates = coordinates;
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

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
}

