package geo.geopoints.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import geo.geopoints.models.Ggs;
import geo.geopoints.services.GgsService;
import geo.geopoints.util.GgsJsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ggs")
public class GgsController {
    private final GgsService ggsService;
    private final GgsJsonParser ggsJsonParser;
    @Autowired
    public GgsController(GgsService ggsService, GgsJsonParser ggsJsonParser) {
        this.ggsService = ggsService;
        this.ggsJsonParser = ggsJsonParser;
    }

    @GetMapping()
    public List<Ggs> listOfPoints(@RequestBody Map<String, String> request) {
        System.out.println(ggsService.listOfGgs(request.get("x"), request.get("y")));
        return ggsService.listOfGgs(request.get("x"), request.get("y"));
    }
    @PostMapping("/add")
    public void ggsToDB(@RequestBody String request) throws JsonProcessingException {

        ggsService.saveGgs(ggsJsonParser.parseJsonToGgs(request));

    }

}
