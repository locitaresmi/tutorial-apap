package apap.tutorial.pergipergi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/")
    private String home(){
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/error/{errorCondition}")
    public String error(
            @PathVariable String errorCondition,
            Model model
    ){

        String activity = "";
        String cause = "";

        if(errorCondition.equals("agensi-delete")){
            activity = "Agensi tidak dapat dihapus";
            cause = "agensi masih dibuka atau agensi masih memiliki tour guide";
        }

        if(errorCondition.equals("tour-guide-update")){
            activity = "Tour guide tidak dapat di-update";
            cause = "agensi masih dibuka";
        }
        if(errorCondition.equals("tour-guide-delete")){
            activity = "Tour guide tidak dapat dihapus";
            cause = "agensi masih dibuka";
        }

        model.addAttribute("activity", activity);
        model.addAttribute("cause", cause);
        return "error-condition";
    }
}
