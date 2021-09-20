package apap.tutorial.pergipergi.model;

public class TravelAgensiModel {
    private String idAgensi;
    private String namaAgensi;
    private String alamat;
    private String noTelepon;
    private Integer kodeTravel;

    public TravelAgensiModel(String idAgensi, String namaAgensi, String alamat, String noTelepon, Integer kodeTravel) {
        this.idAgensi = idAgensi;
        this.namaAgensi = namaAgensi;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.kodeTravel = kodeTravel;
    }

    public Integer getKodeTravel() {
        return kodeTravel;
    }

    public String getIdAgensi() {
        return idAgensi;
    }

    public String getNamaAgensi() {
        return namaAgensi;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setKodeTravel(Integer kodeTravel) {
        this.kodeTravel = kodeTravel;
    }

    public void setIdAgensi(String idAgensi) {
        this.idAgensi = idAgensi;
    }

    public void setNamaAgensi(String namaAgensi) {
        this.namaAgensi = namaAgensi;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
}
