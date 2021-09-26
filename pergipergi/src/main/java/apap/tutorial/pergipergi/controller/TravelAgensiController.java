package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.service.TravelAgensiService;
import org.apache.tomcat.jni.Local;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TravelAgensiController {

    @Qualifier("travelAgensiServiceImpl")
    @Autowired
    private TravelAgensiService travelAgensiService;

    @RequestMapping(value = "/agensi/view/", method = RequestMethod.GET)
    public RedirectView searchAgensi(
            @RequestParam("noAgensi") Long noAgensi,
            Model model
    ) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8080/agensi/view?noAgensi=" + noAgensi);
        return redirectView;
    }

    @GetMapping("/agensi/add")
    public String addAgensiFormPage(Model model) {
        model.addAttribute("agensi", new TravelAgensiModel());
        return "form-add-agensi";
    }

    @PostMapping("/agensi/add")
    public String addAgensiSubmitPage(
            @ModelAttribute TravelAgensiModel agensi,
            Model model
    ){
        travelAgensiService.addAgensi(agensi);
        model.addAttribute("noAgensi", agensi.getNoAgensi());
        return "add-agensi";
    }

    @GetMapping("/agensi/viewall")
    public String listAgensi(Model model){
        List<TravelAgensiModel> listAgensi = travelAgensiService.getListAgensi();
        model.addAttribute("listAgensi", listAgensi);
        return "viewall-agensi";
    }

    @GetMapping("/agensi/view")
    public String viewDetailAgensiPage(
            @RequestParam(value = "noAgensi") Long noAgensi,
            Model model
    ){
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        List<TourGuideModel> listTourGuide = agensi.getListTourGuide();

        /** flag = true berarti agensi sedang dibuka */
        Boolean flag = false;

        /** flag = true berarti ada tour guide di agensi */
        Boolean flagTourGuide = false;

        if(!listTourGuide.isEmpty()) flagTourGuide = true;

        LocalTime localTime = LocalTime.now();
        if (localTime.compareTo(agensi.getWaktuBuka()) > 0 && localTime.compareTo(agensi.getWaktuTutup()) < 0){
            flag = true;
            if(!flagTourGuide) flagTourGuide = true;
        }

        model.addAttribute("agensi", agensi);
        model.addAttribute("listTourGuide", listTourGuide);
        model.addAttribute( "flag", flag);
        model.addAttribute( "flagTourGuide", flagTourGuide);

        return "view-agensi";
    }

    @GetMapping("/agensi/update/{noAgensi}")
    public String updateAgensiFormPage(
            @PathVariable Long noAgensi,
            Model model
    ){
        TravelAgensiModel agensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        model.addAttribute("agensi", agensi);
        return "form-update-agensi";
    }

    @PostMapping("/agensi/update")
    public String updateAgensiSubmitPage(
            @ModelAttribute TravelAgensiModel agensi,
            Model model
    ){
        TravelAgensiModel updatedAgensi = travelAgensiService.updateAgensi(agensi);
        model.addAttribute("noAgensi", updatedAgensi.getNoAgensi());
        return "update-agensi";
    }

    @GetMapping("/agensi/delete/{noAgensi}")
    public String deleteAgensi(
            @PathVariable Long noAgensi,
            Model model
    ){

        TravelAgensiModel travelAgensi = travelAgensiService.getAgensiByNoAgensi(noAgensi);
        model.addAttribute("noAgensi", noAgensi);

        travelAgensiService.deleteAgensi(travelAgensi);

        return "delete-agensi";
    }

}
