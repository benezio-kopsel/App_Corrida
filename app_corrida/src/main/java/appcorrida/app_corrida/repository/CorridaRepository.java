package appcorrida.app_corrida.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import appcorrida.app_corrida.model.Corrida;

@Repository
public interface CorridaRepository extends JpaRepository<Corrida, Long> {

    // Buscar corridas por motorista (id)
    List<Corrida> findByMotoristaId(Long motoristaId);

    // Buscar corridas por aplicativo (id)
    List<Corrida> findByAplicativoId(Long aplicativoId);
}
