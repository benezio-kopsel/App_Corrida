package appcorrida.app_corrida.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import appcorrida.app_corrida.model.Aplicativo;
import appcorrida.app_corrida.repository.AplicativoRepository;

@Service
public class AplicativoService {
    @Autowired
    private AplicativoRepository aplicativoRepository;

    public List<Aplicativo> listarAplicativo() {
        return aplicativoRepository.findAll();
    }

    public Aplicativo salvarAplicativo(Aplicativo aplicativo) {
        return aplicativoRepository.save(aplicativo);
    }

    public Aplicativo buscarAplicativo(Long id) {
        return aplicativoRepository.findById(id).orElse(null);
    }

    public void deletarAplicativo(Long id) {
        aplicativoRepository.deleteAllById(id);
    }

}
