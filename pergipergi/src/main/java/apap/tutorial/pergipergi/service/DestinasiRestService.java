package apap.tutorial.pergipergi.service;

import apap.tutorial.pergipergi.model.DestinasiModel;

import java.util.List;

public interface DestinasiRestService {
    DestinasiModel createDestinasi(DestinasiModel destinasi);
    List<DestinasiModel> retrieveListDestinasi();
    DestinasiModel getDestinasiByNoDestinasi(Long noAgensi);
    DestinasiModel updateDestinasi(Long noAgensi, DestinasiModel destinasiUpdate);
    void deleteDestinasi(Long noAgensi);
}
