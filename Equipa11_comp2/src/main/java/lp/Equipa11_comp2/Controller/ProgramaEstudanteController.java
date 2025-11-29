package lp.Equipa11_comp2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lp.Equipa11_comp2.Entity.ProgramaEstudante;
import lp.Equipa11_comp2.Service.ProgramaEstudanteService;
import java.util.List;

@RestController
@RequestMapping("/programasEstudante")
public class ProgramaEstudanteController {

    @Autowired
    private ProgramaEstudanteService service;

    @PostMapping("/salvar")
    public ProgramaEstudante salvarPrograma(@RequestBody ProgramaEstudante p) {
        return service.salvarPrograma(p);
    }

    @GetMapping("/listar")
    public List<ProgramaEstudante> listarProgramas() {
        return service.listarProgramas();
    }

    @PostMapping("/{id}/adicionarHoras")
    public void adicionarHoras(@PathVariable Long id, @RequestParam int horas) {
        ProgramaEstudante p = service.salvarPrograma(new ProgramaEstudante()); // simplificação
        service.adicionarHoras(p, horas);
    }

    @PostMapping("/{id}/concluir")
    public void concluirPrograma(@PathVariable Long id) {
        ProgramaEstudante p = service.salvarPrograma(new ProgramaEstudante()); // simplificação
        service.concluirPrograma(p);
    }

    @GetMapping("/{id}/emitirDiploma")
    public boolean emitirDiploma(@PathVariable Long id) {
        ProgramaEstudante p = service.salvarPrograma(new ProgramaEstudante()); // simplificação
        return service.emitirDiploma(p);
    }

    @GetMapping("/{id}/progresso")
    public double getProgresso(@PathVariable Long id) {
        ProgramaEstudante p = service.salvarPrograma(new ProgramaEstudante()); // simplificação
        return service.getProgresso(p);
    }

    @PostMapping("/{id}/cancelar")
    public void cancelarParticipacao(@PathVariable Long id) {
        ProgramaEstudante p = service.salvarPrograma(new ProgramaEstudante()); // simplificação
        service.cancelarParticipacao(p);
    }
}
