package geo.geopoints.controllers;

import geo.geopoints.dto.GgsDTO;
import geo.geopoints.models.Ggs;
import geo.geopoints.services.GgsSetvice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ggs")
public class GgsController {
    //    private final GgsDTO ggsDTO;
    private final GgsSetvice ggsSetvice;


    @Autowired
    public GgsController(GgsSetvice ggsSetvice) {
        this.ggsSetvice = ggsSetvice;
    }

    @GetMapping()
    public List<Ggs> listOfPoints(float[] coordinates) {
        System.out.println(ggsSetvice.listOfGgs(coordinates));
        return ggsSetvice.listOfGgs(coordinates);
    }

//    private List<GgsDTO> convertToDTO(List<Ggs> listOfGgs) {
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper()
//    }

}
