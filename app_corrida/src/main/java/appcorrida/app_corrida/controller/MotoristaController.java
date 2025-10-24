package appcorrida.app_corrida.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import appcorrida.app_corrida.model.Corrida;
import appcorrida.app_corrida.model.Motorista;
import appcorrida.app_corrida.service.CorridaService;
import appcorrida.app_corrida.service.MotoristaService;

@Controller
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @Autowired
    private CorridaService corridaService;

    // Listar todos os motoristas e suas corridas
    @GetMapping
    public String listarMotoristas(Model model) {
        List<Motorista> motorista = motoristaService.listarMotorista();

        // Associa as corridas a cada motorista
        for (Motorista m : motorista) {
            List<Corrida> corridas = corridaService.getCorridaByMotoristaId(m.getId());
            m.setCorridas(corridas); // supondo que Motorista tenha atributo List<Corrida> corridas
        }
        model.addAttribute("motorista", motorista);
        return "Lista_Motorista";
    }

    // Formulário para criar um novo motorista
    @GetMapping("/novo")
    public String novoMotorista(Model model) {
        model.addAttribute("motorista", new Motorista());
        return "Form_Motorista";
    }

    // Salvar motorista (novo ou editado)
    @PostMapping
    public String salvarMotorista(@ModelAttribute Motorista motorista) {
        motoristaService.salvarMotorista(motorista);
        return "redirect:/motorista";
    }

    // Editar motorista
    @GetMapping("/{id}/editar")
    public String editarMotorista(@PathVariable Long id, Model model) {
        Motorista motorista = motoristaService.buscarMotorista(id);
        model.addAttribute("motorista", motorista);
        return "Form_Motorista";
    }

    // Deletar motorista
    @GetMapping("/{id}/deletar")
    public String deletarMotorista(@PathVariable Long id) {
        motoristaService.deletarMotorista(id);
        return "redirect:/motorista";
    }
}
