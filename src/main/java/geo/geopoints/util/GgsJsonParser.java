package geo.geopoints.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import geo.geopoints.models.Ggs;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GgsJsonParser {
    ObjectMapper objectMapper = new ObjectMapper();

    public List<Ggs> parseJsonToGgs(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ggs> points = new ArrayList<>();


        String regExForCoord = "\"coordinates\":\\[\\s*-?\\d+(?:\\.\\d+)?(?:e[+-]?\\d+)?\\s*,\\s*-?\\d+(?:\\.\\d+)?(?:e[+-]?\\d+)?\\s*\\]";
        String regExForIndex = "\"index\":\"[^\"]+\"";
        String regExForMark = "\"mark\":\"[^\"]+\"";
        String regExForCenterType =  "\"centertype\":\"[^\"]+\"";
        String regExForSighType = "\"signtype\":\"[^\"]+\"";
        String regExForName = "\"name\":\"[^\"]+\"";
        Pattern pattern = Pattern.compile(regExForName);
        Pattern patternIndex = Pattern.compile(regExForIndex);
        Pattern patternMark = Pattern.compile(regExForMark);
        Pattern patternSightipe = Pattern.compile(regExForSighType);
        Pattern patternCentertype = Pattern.compile(regExForCenterType);
        Pattern patternCoord = Pattern.compile(regExForCoord);
        Matcher matcher = pattern.matcher(json);
        Matcher matcherInd = patternIndex.matcher(json);
        Matcher matcherMaDrk = patternMark.matcher(json);
        Matcher matcherSigh = patternSightipe.matcher(json);
        Matcher matcherCenter = patternCentertype.matcher(json);
        Matcher matcherCoord = patternCoord.matcher(json);
           while(matcher.find()){
               Ggs ggs = new Ggs();
               ggs.setName(matcher.group().replace("\"name\":\"", "")
                       .replace("\"", ""));
               points.add(ggs);
        }
        int counter = 0;
            while(matcherInd.find()){
                points.get(counter++).setIndex(matcherInd.group().replace("\"index\":\"", "")
                        .replace("\"", ""));
            }
        counter = 0;
            while(matcherMaDrk.find()){
                points.get(counter++).setMark(matcherMaDrk.group().replace("\"mark\":\"", "")
                        .replace("\"", ""));
            }
        counter = 0;
            while(matcherSigh.find()){
                points.get(counter++).setSighType(matcherSigh.group().replace("\"signtype\":\"", "")
                        .replace("\"", ""));
            }
        counter = 0;
            while(matcherCenter.find()){
                points.get(counter++).setCenterType(matcherCenter.group().replace("\"centertype\":\"", "")
                        .replace("\"", ""));
            }
        counter = 0;
            while(matcherCoord.find()){
                String[] s = matcherCoord.group().replace("\"coordinates\":[", "")
                        .replace("]", "").split(",");
                double[] coord = {Double.parseDouble(s[0]), Double.parseDouble(s[1])};
                points.get(counter++).setCoordinates(coord);
            }
        counter = 0;

        return points;
    }
}
