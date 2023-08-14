package geo.geopoints.controllers;

import geo.geopoints.models.Ggs;
import geo.geopoints.services.GgsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "x", value = "X coordinate", dataType = "float", paramType = "body", example = "56.237559"),
            @ApiImplicitParam(name = "y", value = "Y coordinate", dataType = "float", paramType = "body", example = "92.134698"),
            @ApiImplicitParam(name = "radius", value = "Radius", dataType = "float", paramType = "body", example = "10")
    })

    public List<Ggs> findByCoordinates(@RequestBody Map<String, Float> request) {
        return ggsService.findByCoordinates(request.get("x"), request.get("y"), request.get("radius"));
    }

    @PostMapping("/msk")
    public List<Ggs> findBymsk(@RequestBody Map<String, String> request) {
        return ggsService.findBymsk(request.get("msk"));
    }

}
