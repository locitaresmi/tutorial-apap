package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.service.TourGuideService;
import apap.tutorial.pergipergi.service.TravelAgensiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TourGuideController {

    @Qualifier("tourGuideServiceImpl")
    @Autowired
    private TourGuideService tourGuideService;

    @Qualifier("travelAgensiServiceImpl")
    @Autowired
    private TravelAgensiService travelAgensiService;

    @GetMapping("/tour-guide/add/{noAgensi}")
    public String addTourGuideFormPage(
            @PathVariable Long noAgensi,
            Model model
    ){
        TourGuideModel guide = new TourGuideModel();
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        guide.setAgensi(agensi);
        model.addAttribute("guide", guide);
        model.addAttribute("noAgensi", noAgensi);
        return "form-add-tour-guide";
    }

    @PostMapping("/tour-guide/add")
    public String addTourGuideSubmitPage(
            @ModelAttribute TourGuideModel tourGuide,
            Model model
    ){
        tourGuideService.addTourGuide(tourGuide);
        model.addAttribute("noTourGuide", tourGuide.getNoTourGuide());
        model.addAttribute("noAgensi", tourGuide.getAgensi().getNoAgensi());
        return "add-tour-guide";
    }

    @GetMapping("/tour-guide/update/{noTourGuide}")
    public String updateTourGuideFormPage(
            @PathVariable Long noTourGuide,
            Model model
    ){

        TourGuideModel tourGuide = tourGuideService.getTourGuideByNoTourGuide(noTourGuide);
        model.addAttribute("tourGuide", tourGuide);
        model.addAttribute("noAgensi", tourGuide.getAgensi().getNoAgensi());
        return "form-update-tour-guide";
    }

    @PostMapping("/tour-guide/update")
    public String updateTourGuideSubmitPage(
            @ModelAttribute TourGuideModel tourGuide,
            Model model
    ){
        TourGuideModel updatedTourGuide = tourGuideService.updateTourGuide(tourGuide);
        model.addAttribute("noTourGuide", updatedTourGuide.getNoTourGuide());
        model.addAttribute("noAgensi", updatedTourGuide.getAgensi().getNoAgensi());
        return "update-tour-guide";
    }

    @GetMapping("/tour-guide/delete/{noTourGuide}")
    public String deleteTourGuide(
            @PathVariable Long noTourGuide,
            Model model
    ){

        TourGuideModel tourGuide = tourGuideService.getTourGuideByNoTourGuide(noTourGuide);
        model.addAttribute("noTourGuide", noTourGuide);
        model.addAttribute("noAgensi", tourGuide.getAgensi().getNoAgensi());

        tourGuideService.deleteTourGuide(tourGuide);

        return "delete-tour-guide";
    }

}
