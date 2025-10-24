package appcorrida.app_corrida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import appcorrida.app_corrida.model.Motorista;

public interface MotoristaRepository extends JpaRepository<Motorista, Long> {

}
