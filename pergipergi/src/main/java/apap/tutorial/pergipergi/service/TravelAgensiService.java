package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.TourGuideModel;
import apap.tutorial.pergipergi.model.TravelAgensiModel;

import java.util.List;

public interface TravelAgensiService {
    //Method untuk menambahkan agensi
    void addAgensi(TravelAgensiModel travelAgensi);

    //Method untuk mendapatkan daftar agensi yang telah tersimpan
    List<TravelAgensiModel> getListAgensi();

    //Method untuk mendapatkan data agensi berdasarkan no agensi
    TravelAgensiModel getAgensiByNoAgensi(Long idAgensi);

    //Method untuk mengupdate agensi
    TravelAgensiModel updateAgensi(TravelAgensiModel travelAgensi);

    //Method untuk menghapus agensi
    TravelAgensiModel deleteAgensi(TravelAgensiModel travelAgensi);
}
