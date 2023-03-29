package geo.geopoints.dto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import geo.geopoints.models.Gns;
import geo.geopoints.repositories.GgsRepository;
import geo.geopoints.services.GgsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class GnsDTO {
    @Autowired
    GgsService ggsService;
    private String type;
    private double[] bbox;
    private Map<String, Object> geometry;
    private Map<String, Object> properties;

    public GnsDTO( String type, double[] bbox, Map<String, Object> geometry, Map<String, Object> properties) {

        this.type = type;
        this.bbox = bbox;
        this.geometry = geometry;
        this.properties = properties;
    }

    public GnsDTO() {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getBbox() {
        return bbox;
    }

    public void setBbox(double[] bbox) {
        this.bbox = bbox;
    }

    public Map<String, Object> getGeometry() {
        return geometry;
    }

    public void setGeometry(Map<String, Object> geometry) {
        this.geometry = geometry;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public List<Gns> convertToGns(String request) throws JsonProcessingException {
        request = request.replace("{\"entities\":", "")
                .replaceAll(",\"entityCount\":\\d+}", "");
        List<Gns> points = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        GnsDTO[] gnsDTO = objectMapper.readValue(request, GnsDTO[].class);
        String msk = ggsService.findByRegions_ref(gnsDTO[0].properties.get("regions_ref").toString()).get(0).getMsk();
        for (GnsDTO element : gnsDTO) {
            Gns gns = new Gns();
            gns.setMaingeographyfeature((String) element.properties.get("maingeographyfeature"));
            gns.setName((String) element.properties.get("name"));
            gns.setIndex((String) element.properties.get("index"));
            gns.setCenterType((String) element.properties.get("centertype"));
            gns.setSighType((String) element.properties.get("signtype"));
            gns.setMark((String) element.properties.get("mark"));
            gns.setMsk(msk);
            gns.setRegions_ref(element.properties.get("regions_ref").toString()) ;
            gns.setCoordinates(new double[]{new ArrayList<Double>((Collection<? extends Double>) element.geometry.get("coordinates")).get(0),
                    new ArrayList<Double>((Collection<? extends Double>) element.geometry.get("coordinates")).get(1)});

            points.add(gns);
        }
        return points;
    }
}