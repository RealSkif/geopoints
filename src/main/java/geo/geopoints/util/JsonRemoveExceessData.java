package geo.geopoints.util;

import geo.geopoints.models.Ggs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonRemoveExceessData {
    public static void main(String[] args) {
        String json = "{\"entities\":[{\"type\":\"Feature\",\"bbox\":[86.183621212,53.032819913,86.183621212,53.032819913],\"geometry\":{\"type\":\"Point\",\"coordinates\":[86.183621212,53.032819913]},\"properties\":{\"regions_ref\":[1,207],\"districts_ref\":[1797],\"index\":\"N4527303\",\"mark\":\"б/№\",\"class_ref\":6,\"signtype\":\"пир.\",\"centertype\":\"1\",\"epsgs\":\"[{\\\"EPSG\\\":\\\"20015\\\",\\\"value\\\":\\\"СК-95 зона 15\\\"},{\\\"EPSG\\\":\\\"80201115\\\",\\\"value\\\":\\\"ГСК-2011 зона 15\\\"},{\\\"EPSG\\\":\\\"28415\\\",\\\"value\\\":\\\"СК-42 зона 15\\\"},{\\\"EPSG\\\":\\\"632203\\\",\\\"value\\\":\\\"МСК-22 Алтайcкий край, зона 3\\\"}]\",\"guid\":\"3a017aa8-9890-0c0e-cb51-2de143758517\",\"name\":\"Усть-Ангуреп\"}}],\"entityCount\":4142}";

        String regExForCoord = "\"coordinates\":\\[\\s*-?\\d+(?:\\.\\d+)?(?:e[+-]?\\d+)?\\s*,\\s*-?\\d+(?:\\.\\d+)?(?:e[+-]?\\d+)?\\s*\\]";
        String regExForIndex = "\"index\":\"[^\"]+\"";
        String regExForMark = "\"mark\":\"[^\"]+\"";
        String regExForCenterType =  "\"centertype\":\"[^\"]+\"";
        String regExForSighType = "\"signtype\":\"[^\"]+\"";
        String regExForName = "\"name\":\"[^\"]+\"";

        Pattern patternName = Pattern.compile(regExForName);
        Pattern patternIndex = Pattern.compile(regExForIndex);
        Pattern patternMark = Pattern.compile(regExForMark);
        Pattern patternSightipe = Pattern.compile(regExForSighType);
        Pattern patternCentertype = Pattern.compile(regExForCenterType);
        Pattern patternCoord = Pattern.compile(regExForCoord);

        Matcher matcherName = patternName.matcher(json);
        Matcher matcherInd = patternIndex.matcher(json);
        Matcher matcherMaDrk = patternMark.matcher(json);
        Matcher matcherSigh = patternSightipe.matcher(json);
        Matcher matcherCenter = patternCentertype.matcher(json);
        Matcher matcherCoord = patternCoord.matcher(json);
        while(matcherName.find()){

            System.out.println((matcherName.group().replace("\"name\":\"", "")
                    .replace("\"", "")));

        }
        int counter = 0;
        while(matcherInd.find()){
            System.out.println(matcherInd.group().replace("\"index\":\"", "")
                    .replace("\"", ""));
        }
        counter = 0;
        while(matcherMaDrk.find()){
            System.out.println(matcherMaDrk.group().replace("\"mark\":\"", "")
                    .replace("\"", ""));
        }
        counter = 0;
        while(matcherSigh.find()){
            System.out.println(matcherSigh.group().replace("\"signtype\":\"", "")
                    .replace("\"", ""));
        }
        counter = 0;
        while(matcherCenter.find()){
            System.out.println(matcherCenter.group().replace("\"centertype\":\"", "")
                    .replace("\"", ""));
        }
        counter = 0;
        while(matcherCoord.find()){
            System.out.println( matcherCoord.group().replace("\"coordinates\":[", "")
                    .replace("]", ""));

        }
        counter = 0;
    }
}
