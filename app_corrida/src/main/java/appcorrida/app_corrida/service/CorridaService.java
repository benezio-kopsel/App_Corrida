package appcorrida.app_corrida.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import appcorrida.app_corrida.model.Corrida;
import appcorrida.app_corrida.repository.CorridaRepository;

@Service
public class CorridaService {
    @Autowired
    private CorridaRepository corridaRepository;

        public List<Corrida> listarCorrida(){
            return corridaRepository.findAll();
        }

        public List<Corrida> getCorridaByMotoristaId(Long motoristaId) {
            return corridaRepository.findByMotoristaId(motoristaId);
        }

        public List<Corrida> getCorridaByAplicativoId(Long aplicativoId) {
            return corridaRepository.findByAplicativoId(aplicativoId);
        }

        public Corrida salvarCorrida(Corrida corrida) {
            return corridaRepository.save(corrida);
        }

        public Corrida buscarCorrida(Long id) {
            return corridaRepository.findById(id).orElse(null);
        }

        public void deletarCorrida(Long id) {
            corridaRepository.deleteById(id);
        }
}
