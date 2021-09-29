package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;

public interface TourGuideService {

    void addTourGuide(TourGuideModel tourGuide);

    TourGuideModel getTourGuideByNoTourGuide(Long noTourGuide);

    TourGuideModel updateTourGuide(TourGuideModel tourGuide);

    TourGuideModel deleteTourGuide(TourGuideModel tourGuide);

}
