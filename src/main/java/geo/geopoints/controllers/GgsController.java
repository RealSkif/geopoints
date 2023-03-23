package geo.geopoints.controllers;

import geo.geopoints.dto.GgsDTO;
import geo.geopoints.models.Ggs;
import geo.geopoints.services.GgsSetvice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ggs")
public class GgsController {
    //    private final GgsDTO ggsDTO;
    private final GgsSetvice ggsSetvice;


    @Autowired
    public GgsController(GgsSetvice ggsSetvice) {
        this.ggsSetvice = ggsSetvice;
    }
//    RestTemplate restTemplate = new RestTemplate();
//    String fooResourceUrl
//            = "http://localhost:5432/ggs";
//    ResponseEntity<String> response
//            = restTemplate.getForEntity(fooResourceUrl, String.class);

    @GetMapping()
    public List<Ggs> listOfPoints(@RequestBody Map<String, String> request) {
        String x = request.get("x");
        String y = request.get("y");
        double [] coordinates = new double[2];
        coordinates[0] = Double.parseDouble(x);
        coordinates[1] = Double.parseDouble(y);
        System.out.println(ggsSetvice.listOfGgs(coordinates));
        return ggsSetvice.listOfGgs(coordinates);
    }
//    public List<MyObject> getObjects(@RequestParam("key1") String key1Value, @RequestParam("key2") String key2Value) {
//        // Use the key-value pairs to query your data source and return a list of objects
//        List<MyObject> objects = // your logic here

//    private List<GgsDTO> convertToDTO(List<Ggs> listOfGgs) {
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper()
//    }

}
