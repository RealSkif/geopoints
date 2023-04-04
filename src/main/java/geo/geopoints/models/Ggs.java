package geo.geopoints.models;

import jakarta.persistence.*;

import java.util.ArrayList;

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
    private  String mark;
    @Column(name = "sightype")
    private  String sighType;
    @Column(name = "centertype")
    private  String centerType;
    @Column(name = "msk")
    private  String msk;
    @Column(name = "regions_ref")
    private  String regions;
    @Column(name = "latitude")
    private double latitude;
    @Column(name = "longitude")
    private double longitude;

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

    public Ggs() {
    }

    public Ggs(String name, String index, String mark, String sighType, String centerType,
               String msk, String regions, double latitude, double longitude) {
        this.name = name;
        this.index = index;
        this.mark = mark;
        this.sighType = sighType;
        this.centerType = centerType;
        this.msk = msk;
        this.regions = regions;
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

    public String getMsk() {
        return msk;
    }

    public void setMsk(String msk) {
        this.msk = msk;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions_ref) {
        this.regions = regions_ref;
    }

}
