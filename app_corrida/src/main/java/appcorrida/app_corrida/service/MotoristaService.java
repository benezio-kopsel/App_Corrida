package appcorrida.app_corrida.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appcorrida.app_corrida.model.Motorista;
import appcorrida.app_corrida.repository.MotoristaRepository;

@Service
public class MotoristaService {
    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<Motorista> listarMotorista() {
        return motoristaRepository.findAll();
    }

    public Motorista salvarMotorista(Motorista motorista) {
        return motoristaRepository.save(motorista);
    }

    public Motorista buscarMotorista(Long id) {
        return motoristaRepository.findById(id).orElse(null);
    }

    public void deletarMotorista(Long id){
        motoristaRepository.deleteById(id);
    }

}
