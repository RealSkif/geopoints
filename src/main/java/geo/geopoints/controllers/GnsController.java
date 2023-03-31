package geo.geopoints.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import geo.geopoints.dto.GnsDTO;
import geo.geopoints.models.Gns;
import geo.geopoints.services.GnsService;
import org.modelmapper.ModelMapper;
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

    private final GnsDTO gnsDTO;

    @Autowired
    public GnsController(GnsService gnsService, GnsDTO gnsDTO) {
        this.gnsService = gnsService;
        this.gnsDTO = gnsDTO;
    }

    @PostMapping("/msk")
    public List<Gns> findBymsk(@RequestBody Map<String, String> request) {
        return gnsService.findBymsk(request.get("msk"));
    }

    @PostMapping()
    public List<Gns> findByCoordinates(@RequestBody Map<String, Double> request) {
        return gnsService.findByCoordinates(request.get("x"), request.get("y"), request.get("radius"));
    }

    @PostMapping("/add")
    public void gnsToDB(@RequestBody String request) throws JsonProcessingException {
        gnsService.saveGns(gnsDTO.convertToGns(request));
    }

}
