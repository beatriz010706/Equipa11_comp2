package lp.Equipa11_comp2.Controller;
/**
 * @author diogo garcia
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lp.Equipa11_comp2.Entity.Tipo;
import lp.Equipa11_comp2.Entity.Parceiro;
import lp.Equipa11_comp2.Entity.ProgramaVoluntariado;
import lp.Equipa11_comp2.Service.TipoService;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoService service;

    @PostMapping("/salvar")
    public Tipo salvarTipo(@RequestBody Tipo t) {
        return service.salvarTipo(t);
    }

    @GetMapping("/listar")
    public List<Tipo> listarTipos() {
        return service.listarTipos();
    }

    @PostMapping("/{id}/adicionarParceiro")
    public void adicionarParceiro(@PathVariable Long id, @RequestBody Parceiro p) {
        Tipo t = service.listarTipos().stream()
                     .filter(tipo -> tipo.getIdTipo().equals(id))
                     .findFirst().orElse(null);
        if (t != null) service.adicionarParceiro(t, p);
    }

    @PostMapping("/{id}/removerParceiro")
    public void removerParceiro(@PathVariable Long id, @RequestBody Parceiro p) {
        Tipo t = service.listarTipos().stream()
                     .filter(tipo -> tipo.getIdTipo().equals(id))
                     .findFirst().orElse(null);
        if (t != null) service.removerParceiro(t, p);
    }

    @PostMapping("/{id}/adicionarPrograma")
    public void adicionarPrograma(@PathVariable Long id, @RequestBody ProgramaVoluntariado p) {
        Tipo t = service.listarTipos().stream()
                     .filter(tipo -> tipo.getIdTipo().equals(id))
                     .findFirst().orElse(null);
        if (t != null) service.adicionarPrograma(t, p);
    }

    @PostMapping("/{id}/removerPrograma")
    public void removerPrograma(@PathVariable Long id, @RequestBody ProgramaVoluntariado p) {
        Tipo t = service.listarTipos().stream()
                     .filter(tipo -> tipo.getIdTipo().equals(id))
                     .findFirst().orElse(null);
        if (t != null) service.removerPrograma(t, p);
    }
}//fim classe
