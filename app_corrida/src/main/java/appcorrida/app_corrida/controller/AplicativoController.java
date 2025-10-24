package appcorrida.app_corrida.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import appcorrida.app_corrida.model.Aplicativo;
import appcorrida.app_corrida.service.AplicativoService;

@Controller
@RequestMapping("/aplicativo")
public class AplicativoController {

    @Autowired
    private AplicativoService aplicativoService;

    // ✅ LISTAR Aplicativo
    @GetMapping
    public String listarAplicativo(Model model) {
        List<Aplicativo> aplicativo = aplicativoService.listarAplicativo();
        model.addAttribute("aplicativo", aplicativo);
        return "Lista_Aplicativo";
    }

    // ✅ FORMULÁRIO DE NOVO Aplicativo
    @GetMapping("/novo")
    public String novoAplicativo(Model model) {
        model.addAttribute("aplicativo", new Aplicativo());
        return "Form_Aplicativo";
    }

    // ✅ SALVAR Aplicativo
    @PostMapping
    public String salvarAplicativo(@ModelAttribute Aplicativo aplicativo) {
        aplicativoService.salvarAplicativo(aplicativo);
        return "redirect:/aplicativo";
}

    // ✅ EDITAR Aplicativo
    @GetMapping("/{id}/editar")
    public String editarAplicativo(@PathVariable Long id, Model model) {
        Aplicativo aplicativo = aplicativoService.buscarAplicativo(id);
        model.addAttribute("aplicativo", aplicativo);
        return "Form_Aplicativo";
    }

    // ✅ DELETAR Aplicativo
    @GetMapping("/{id}/deletar")
    public String deletarAplicativo(@PathVariable Long id) {
        aplicativoService.deletarAplicativo(id);
        return "redirect:/aplicativo";
    }
}
