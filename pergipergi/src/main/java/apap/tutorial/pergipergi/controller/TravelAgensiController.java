package apap.tutorial.pergipergi.controller;

import apap.tutorial.pergipergi.model.TravelAgensiModel;
import apap.tutorial.pergipergi.service.TravelAgensiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TravelAgensiController {
    @Autowired
    private TravelAgensiService travelAgensiService;

    //Routing URL yang diinginkan
    @RequestMapping("agensi/add")
    public String addAgensi(
            @RequestParam(value = "idAgensi", required = true) String idAgensi,
            @RequestParam(value = "namaAgensi", required = true) String namaAgensi,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            @RequestParam(value = "kodeTravel", required = true) Integer kodeTravel,
            Model model
    ){

        //Membuat objek TravelAgensiModel
        TravelAgensiModel agensi = new TravelAgensiModel(idAgensi, namaAgensi, alamat, noTelepon, kodeTravel);

        //Memanggil servis addAgensi
        travelAgensiService.addAgensi(agensi);

        //Add variabel id agensi ke 'idAgensi' untuk dirender di thymeleaf
        model.addAttribute("idAgensi", idAgensi);

        //return view template yang digunakan
        return "add-agensi";

    }

    @RequestMapping("agensi/viewAll")
    public String listAgensi(Model model){
        //Mendapatkan semua TravelAgensiModel
        List<TravelAgensiModel> listAgensi = travelAgensiService.getListAgensi();

        //Add variabel semua TravelAgensiModel ke "listAgensi" untuk dirender pada thymeleaf
        model.addAttribute("listAgensi", listAgensi);

        //Return view template yang diinginkan
        return "viewall-agensi";
    }

    //@RequestMapping("agensi/view")
    @GetMapping("agensi/view/id-agensi/{id}")
    public String detailAgensi(
            //@RequestParam(value = "idAgensi") String idAgensi,
            @PathVariable("id") String idAgensi,
            Model model
    ){
        //Mendapatkan TravelAgensiModel sesuai dengan idAgensi
        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);

        if(agensi == null) {
            model.addAttribute("request", "View");
            return "error-agensi";
        }

        //Add variabel TravelAgensiModel ke "agensi" untuk dirender pada thymeleaf
        model.addAttribute("agensi", agensi);

        return "view-agensi";
    }

    @GetMapping("agensi/update/id-agensi/{id}/no-telepon/{no-telepon}")
    public String ubahTelepon(
            @PathVariable("id") String idAgensi,
            @PathVariable("no-telepon") String noTelepon,
            Model model
    ){
        //Mendapatkan TravelAgensiModel sesuai dengan idAgensi
        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);

        if(agensi == null) {
            model.addAttribute("request", "Update");
            return "error-agensi";
        }

        //Add variabel noTeleponLama untuk dirender pada thymeleaf
        model.addAttribute("noTeleponLama", agensi.getNoTelepon());

        //Memanggil method setter untuk mengubah no telepon agensi tersebut
        agensi.setNoTelepon(noTelepon);

        //Add variabel idAgensi dan noTeleponBaru untuk dirender pada thymeleaf
        model.addAttribute("idAgensi", idAgensi);
        model.addAttribute("noTeleponBaru", noTelepon);

        return "update-agensi";
    }

    @GetMapping("agensi/delete/id-agensi/{id}")
    public String deleteAgensi(
            @PathVariable("id") String idAgensi,
            Model model
    ){
        //Mendapatkan TravelAgensiModel sesuai dengan idAgensi
        TravelAgensiModel agensi = travelAgensiService.getAgensiByidAgensi(idAgensi);

        if(agensi == null) {
            model.addAttribute("request", "Delete");
            return "error-agensi";
        }

        //Add variabel id agensi ke 'idAgensi' untuk dirender di thymeleaf
        model.addAttribute("idAgensi", idAgensi);

        //Menghapus data agensi dari listAgensi
        travelAgensiService.getListAgensi().remove(agensi);

        return "delete-agensi";
    }

    @GetMapping("agensi/update/kodeTravel/{kode}")
    public String updateAgensi2(
            @PathVariable("kode") Integer kodeTravel,
            Model model
    ){

        if(kodeTravel/2 == 0){
            return "error-kodeTravel";
        }

        else{

            TravelAgensiModel agensi = travelAgensiService.getAgensiByKodeTravel(kodeTravel);

            if(agensi == null) {
                return "error";
            }

            model.addAttribute("kodeTravelLama", agensi.getKodeTravel());
            agensi.setKodeTravel(kodeTravel);

            //Add variabel kodetravel untuk dirender pada thymeleaf
            model.addAttribute("kodeTravelBaru", kodeTravel);

            return "update-kodeTravel";
        }
    }

    
}
