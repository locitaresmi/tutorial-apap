package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TravelAgensiModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelAgensiServiceImpl implements TravelAgensiService{

    private List<TravelAgensiModel> listAgensi;

    public TravelAgensiServiceImpl(){
        listAgensi = new ArrayList<>();
    }

    //Method untuk menambahkan agensi
    @Override
    public void addAgensi(TravelAgensiModel travelAgensiModel){
        listAgensi.add(travelAgensiModel);
    }

    //Method untuk mendapatkan daftar agensi yang telah tersimpan
    @Override
    public List<TravelAgensiModel> getListAgensi(){
        return listAgensi;
    }

    //Method untuk mendapatkan data agensi berdasarkan id agensi
    @Override
    public TravelAgensiModel getAgensiByidAgensi(String idAgensi){
        for (TravelAgensiModel i : listAgensi){
            if (i.getIdAgensi().equals(idAgensi)) return i;
        }
        return null;
    }

    @Override
    public TravelAgensiModel getAgensiByKodeTravel(Integer kodeTravel){
        for (TravelAgensiModel i : listAgensi){
            if (i.getKodeTravel() == kodeTravel) return i;
        }
        return null;
    }
}
