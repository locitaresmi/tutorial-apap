package apap.tutorial.pergipergi.repository;

import apap.tutorial.pergipergi.model.DestinasiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DestinasiDb extends JpaRepository<DestinasiModel, Long> {
    Optional<DestinasiModel> findByNoDestinasi(Long noDestinasi);
    Optional<DestinasiModel> findByNegaraDestinasi(String negaraDestinasi);
}
