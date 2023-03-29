package geo.geopoints.dto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import geo.geopoints.models.Ggs;

import java.util.*;

public class GgsDTO {
    private String type;
    private double[] bbox;
    private Map<String, Object> geometry;
    private Map<String, Object> properties;

    public GgsDTO(String type, double[] bbox, Map<String, Object> geometry, Map<String, Object> properties) {
        this.type = type;
        this.bbox = bbox;
        this.geometry = geometry;
        this.properties = properties;
    }

    public GgsDTO() {
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

    public Map<String, Object> getProperties(String regionsRef) {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public List<Ggs> convertToGgs(String request) throws JsonProcessingException {
        request = request.replace("{\"entities\":", "")
                .replaceAll(",\"entityCount\":\\d+}", "");
        List<Ggs> points = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        GgsDTO[] ggsDTO = objectMapper.readValue(request, GgsDTO[].class);
        for (GgsDTO element : ggsDTO) {
            Ggs ggs = new Ggs();
            ggs.setName((String) element.properties.get("name"));
            ggs.setIndex((String) element.properties.get("index"));
            ggs.setCenterType((String) element.properties.get("centertype"));
            ggs.setSighType((String) element.properties.get("signtype"));
            ggs.setMark((String) element.properties.get("mark"));
            String msk = (String) element.properties.get("epsgs");
            if(msk == null)ggs.setMsk("-");
            else ggs.setMsk(msk.replaceAll(".*\"МСК-", "")
                    .replaceAll("\\s.*$", ""));
            ggs.setRegions(element.properties.get("regions_ref").toString()) ;
            ggs.setCoordinates(new double[]{new ArrayList<Double>((Collection<? extends Double>) element.geometry.get("coordinates")).get(0),
                    new ArrayList<Double>((Collection<? extends Double>) element.geometry.get("coordinates")).get(1)});
            points.add(ggs);
        }
        return points;
    }
}