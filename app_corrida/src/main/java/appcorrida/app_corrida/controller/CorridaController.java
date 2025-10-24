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
import appcorrida.app_corrida.service.AplicativoService;
import appcorrida.app_corrida.service.CorridaService;
import appcorrida.app_corrida.service.MotoristaService;

@Controller
@RequestMapping("/corrida")
public class CorridaController {

    @Autowired
    private CorridaService corridaService;

    @Autowired
    private MotoristaService motoristaService;

    @Autowired
    private AplicativoService aplicativoService;

    // Listar Corridas
    @GetMapping
    public String listarCorrida(Model model) {
        List<Corrida> corrida = corridaService.listarCorrida();
        model.addAttribute("corrida", corrida);
        return "Lista_Corrida";
    }

    // Formulário de nova corrida
    @GetMapping("/novo")
    public String novaCorrida(Model model) {
        model.addAttribute("corrida", new Corrida());
        model.addAttribute("motoristas", motoristaService.listarMotorista());
        model.addAttribute("aplicativos", aplicativoService.listarAplicativo());
        return "Form_Corrida";
    }

    // Salvar corrida
    @PostMapping
    public String salvarCorrida(@ModelAttribute Corrida corrida) {
        corridaService.salvarCorrida(corrida);
        return "redirect:/corrida";
    }

    // Editar corrida
    @GetMapping("/{id}/editar")
    public String editarCorrida(@PathVariable Long id, Model model) {
        Corrida corrida = corridaService.buscarCorrida(id);
        model.addAttribute("corrida", corrida);
        model.addAttribute("motoristas", motoristaService.listarMotorista());
        model.addAttribute("aplicativos", aplicativoService.listarAplicativo());
        return "Form_Corrida";
    }

    // Deletar corrida
    @GetMapping("/{id}/deletar")
    public String deletarCorrida(@PathVariable Long id) {
        corridaService.deletarCorrida(id);
        return "redirect:/corrida";
    }
}
