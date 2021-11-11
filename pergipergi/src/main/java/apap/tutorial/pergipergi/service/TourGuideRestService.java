package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.rest.PrediksiUmur;
import reactor.core.publisher.Mono;

import java.io.IOException;

public interface TourGuideRestService {

    TourGuideModel getTourGuideByNoTourGuide(Long noTourGuide);
    TourGuideModel prediksiUmur(Long noTourGuide) throws IOException;
}
