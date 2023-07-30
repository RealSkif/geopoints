package geo.geopoints.controllers;

import geo.geopoints.models.Gns;
import geo.geopoints.services.GnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/gns")

public class GnsController {
    private final GnsService gnsService;

    @Autowired
    public GnsController(GnsService gnsService) {
        this.gnsService = gnsService;
    }

    @PostMapping("/msk")
    public List<Gns> findBymsk(@RequestBody Map<String, String> request) {
        return gnsService.findBymsk(request.get("msk"));
    }

    @PostMapping()
    public List<Gns> findByCoordinates(@RequestBody Map<String, Double> request) {
        return gnsService.findByCoordinates(request.get("x"), request.get("y"), request.get("radius"));
    }

}
