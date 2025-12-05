package lp.Equipa11_comp2.Controller;

/**
 * @author miguel silva
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import lp.Equipa11_comp2.Entity.ProgramaVoluntariado;
import lp.Equipa11_comp2.Entity.Candidatura;
import lp.Equipa11_comp2.Service.ProgramaVoluntariadoService;

@RestController
@RequestMapping("/programas")
public class ProgramaVoluntariadoController {

    @Autowired
    private ProgramaVoluntariadoService service;

    @PostMapping("/candidatura")
    public void inserirCandidatura(@RequestBody Candidatura c, @RequestParam Long idPrograma) {
        ProgramaVoluntariado p = new ProgramaVoluntariado();
        p.setId(idPrograma);
        service.inserirCandidatura(p, c);
    }

    @GetMapping("/{id}/pendentes")
    public List<Candidatura> listarPendentes(@PathVariable Long id) {
        ProgramaVoluntariado p = new ProgramaVoluntariado();
        p.setId(id);
        return service.listarCandidaturasPendentes(p);
    }

    @GetMapping("/{id}/participantes")
    public List<Candidatura> listarParticipantes(@PathVariable Long id) {
        ProgramaVoluntariado p = new ProgramaVoluntariado();
        p.setId(id);
        return service.listarParticipantes(p);
    }

    @GetMapping("/{id}/vagas")
    public boolean verificarVagas(@PathVariable Long id) {
        ProgramaVoluntariado p = new ProgramaVoluntariado();
        p.setId(id);
        return service.verificarVagasDisponiveis(p);
    }
}//fim classe
