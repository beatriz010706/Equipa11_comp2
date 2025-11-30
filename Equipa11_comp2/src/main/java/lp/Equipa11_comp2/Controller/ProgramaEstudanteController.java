package lp.Equipa11_comp2.Controller;
/**
 * @author diogo garcia
 */
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
    public String adicionarHoras(@PathVariable Long id, @RequestParam int horas) {
        ProgramaEstudante p = service.getById(id);

        if (p == null) {
            return "Programa não encontrado!";
        }

        service.adicionarHoras(id, horas);
        return "Horas adicionadas com sucesso!";
    }

    @PostMapping("/{id}/concluir")
    public String concluirPrograma(@PathVariable Long id) {
        ProgramaEstudante p = service.getById(id);

        if (p == null) {
            return "Programa não encontrado!";
        }

        service.concluirPrograma(id);
        return "Programa concluído!";
    }

    @GetMapping("/{id}/emitirDiploma")
    public String emitirDiploma(@PathVariable Long id) {
        Boolean diploma = service.emitirDiploma(id);

        if (diploma == null) return "Programa não encontrado!";
        if (!diploma) return "Ainda não tem horas suficientes.";

        return "Diploma disponível!";
    }

    @GetMapping("/{id}/progresso")
    public String getProgresso(@PathVariable Long id) {
        ProgramaEstudante p = service.getById(id);

        if (p == null) return "Programa não encontrado!";

        double progresso = service.getProgresso(id);
        return "Progresso: " + progresso + "%";
    }

    @PostMapping("/{id}/cancelar")
    public String cancelarParticipacao(@PathVariable Long id) {
        ProgramaEstudante p = service.getById(id);

        if (p == null) {
            return "Programa não encontrado!";
        }

        service.cancelarParticipacao(id);
        return "Participação cancelada com sucesso!";
    }
}
