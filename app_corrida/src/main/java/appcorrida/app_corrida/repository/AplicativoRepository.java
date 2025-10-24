package appcorrida.app_corrida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import appcorrida.app_corrida.model.Aplicativo;


public interface AplicativoRepository extends JpaRepository<Aplicativo, Long> {

    void deleteAllById(Long id);

}