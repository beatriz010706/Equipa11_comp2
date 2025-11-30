package lp.Equipa11_comp2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lp.Equipa11_comp2.DTO.ParceiroDTO;
import lp.Equipa11_comp2.Service.ParceiroService;
import lp.Equipa11_comp2.Entity.ProgramaVoluntariado;
import lp.Equipa11_comp2.Entity.Parceiro;

@RestController
@RequestMapping("/parceiros")
public class ParceiroController {

    @Autowired
    private ParceiroService service;

    @PostMapping("/registar")
    public ParceiroDTO registar(@RequestBody ParceiroDTO dto) {
        return service.registar(dto);
    }

    @PostMapping("/login")
    public ParceiroDTO login(@RequestParam String email,
                             @RequestParam String password) {
        return service.login(email, password);
    }

    // Registar programa
    @PostMapping("/{id}/programa/registar")
    public void registarPrograma(@PathVariable Long id, @RequestBody ProgramaVoluntariado prog) {
        Parceiro p = service.findById(id);
        if (p != null) service.registarPrograma(p, prog);
    }

    // Editar programa
    @PostMapping("/{id}/programa/editar")
    public void editarPrograma(@PathVariable Long id, @RequestBody ProgramaVoluntariado prog,
                               @RequestParam String titulo, @RequestParam int horas) {
        Parceiro p = service.findById(id);
        if (p != null) service.editarPrograma(p, prog, titulo, horas);
    }

    // Eliminar programa
    @PostMapping("/{id}/programa/eliminar")
    public void eliminarPrograma(@PathVariable Long id, @RequestBody ProgramaVoluntariado prog) {
        Parceiro p = service.findById(id);
        if (p != null) service.eliminarPrograma(p, prog);
    }
}

