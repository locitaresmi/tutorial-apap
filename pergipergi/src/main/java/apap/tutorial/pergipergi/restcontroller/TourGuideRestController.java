package apap.tutorial.pergipergi.restcontroller;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.service.TourGuideRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class TourGuideRestController {

    @Autowired
    private TourGuideRestService tourGuideRestService;

    @PutMapping(value = "/tour/umur/{noTourGuide}")
    private TourGuideModel prediksiUmur (@PathVariable("noTourGuide") Long noTourGuide) {
        try {
            return tourGuideRestService.prediksiUmur(noTourGuide);
        } catch (NoSuchElementException | IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Tour Guide with No Tour Guide " + String.valueOf(noTourGuide) + " Not Found."
            );
        }
    }

}
