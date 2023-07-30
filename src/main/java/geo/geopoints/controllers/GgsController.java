package geo.geopoints.controllers;

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

    @Autowired
    public GgsController(GgsService ggsService) {
        this.ggsService = ggsService;
    }

    @PostMapping()
    public List<Ggs> findByCoordinates(@RequestBody Map<String, Float> request) {
        return ggsService.findByCoordinates(request.get("x"), request.get("y"), request.get("radius"));
    }

    @PostMapping("/msk")
    public List<Ggs> findBymsk(@RequestBody Map<String, String> request) {
        return ggsService.findBymsk(request.get("msk"));
    }

}
