package geo.geopoints.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import geo.geopoints.dto.GgsDTO;
import geo.geopoints.models.Ggs;
import geo.geopoints.services.GgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ggs")
public class GgsController {
    private final GgsService ggsService;

    private final GgsDTO ggsDTO;

    @Autowired
    public GgsController(GgsService ggsService, GgsDTO ggsDTO) {
        this.ggsService = ggsService;
        this.ggsDTO = ggsDTO;
    }

    @PostMapping()
    public List<Ggs> findByCoordinates(@RequestBody Map<String, Double> request) {
        return ggsService.findByCoordinates(request.get("x"), request.get("y"), request.get("radius"));
    }

    @PostMapping("/add")
    public void ggsToDB(@RequestBody String request) throws JsonProcessingException {
        ggsService.saveGgs(ggsDTO.convertToGgs(request));
    }
}
