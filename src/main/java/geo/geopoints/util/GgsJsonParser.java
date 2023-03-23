package geo.geopoints.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import geo.geopoints.models.Ggs;

import java.util.ArrayList;
import java.util.List;
 class Entity {
    private Geometry geometry;
    private Parameters parameters;
     public Parameters getParameters() {
         return parameters;
     }

     public void setParameters(Parameters parameters) {
         this.parameters = parameters;
     }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }


 }
 class Parameters {private String name;
     private String mark;
     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getMark() {
         return mark;
     }

     public void setMark(String mark) {
         this.mark = mark;
     }

 }

 class Geometry {
    private List<Double> coordinates;

    public List<Double> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }
}

 class Entities {
    private List<Entity> entities;

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}
public class GgsJsonParser {
    ObjectMapper objectMapper = new ObjectMapper();

    public List<Ggs> parseJsonToGgs(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Entities entities = objectMapper.readValue(json, Entities.class);

        for (Entity entity : entities.getEntities()) {
            System.out.println( entity.getGeometry().getCoordinates());
//            System.out.println( entity.getParameters().getName());
//            System.out.println( entity.getParameters().getMark());

            // Do something with the coordinates and name fields
        }
//        JsonNode obj = objectMapper.readTree(json);
//        Ggs ggs = new Ggs();
//        double[] coordinates = new double[2];
//        String s = String.valueOf(obj.get("geometry").get("coordinates"));
//        s = s.replace("[", "").replace("]", "");
//        coordinates[0] = Double.parseDouble(s.split(",")[0]);
//        coordinates[1] = Double.parseDouble(s.split(",")[1]);
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        List<Ggs> employeeList = objectMapper.readValue(json, new TypeReference<>(){});
//        System.out.println(String.valueOf((obj.get("properties").get("index"))));
//        System.out.println(String.valueOf((obj.get("properties").get("mark"))));
//        System.out.println(String.valueOf((obj.get("properties").get("centertype"))));
//        System.out.println(String.valueOf((obj.get("properties").get("signtype"))));
//        System.out.println(String.valueOf((obj.get("properties").get("name"))));
//        System.out.println(employeeList);


//
//        ggs.setCoordinates(coordinates);
//        ggs.setIndex(String.valueOf(((obj.get("properties").get("index"))))
//                .replace("\"", ""));
//        ggs.setMark(String.valueOf((obj.get("properties").get("mark")))
//                .replace("\"", ""));
//        ggs.setCenterType(String.valueOf((obj.get("properties").get("centertype")))
//                .replace("\"", ""));
//        ggs.setSighType(String.valueOf((obj.get("properties").get("signtype")))
//                .replace("\"", ""));
//        ggs.setName(String.valueOf((obj.get("properties").get("name")))
//                .replace("\"", ""));
        List<Ggs> points = new ArrayList<>();
//        points.add(ggs);
        return points;
    }
}
