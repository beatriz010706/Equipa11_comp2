package lp.Equipa11_comp2.Controller;
import java.util.List;

/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lp.Equipa11_comp2.DTO.ParceiroDTO;
import lp.Equipa11_comp2.DTO.ProgramaVoluntariadoDTO;
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
    @PutMapping("/{id}/programa/{progId}/editar")
    public void editarPrograma(@PathVariable Long id, @PathVariable Long progId,@RequestBody ProgramaVoluntariado prog,
    		@RequestParam String titulo, @RequestParam int horas, @RequestParam String local, @RequestParam String descricao, @RequestParam int vagas) {
        Parceiro p = service.findById(id);
        if (p != null) service.editarPrograma(p, prog, titulo, horas);
    }

    // Eliminar programa
    @DeleteMapping("/{id}/programa/{progId}")
    public void eliminarPrograma(@PathVariable Long id, @PathVariable Long progId) {
        Parceiro p = service.findById(id);
        if (p != null) {
            ProgramaVoluntariado prog = new ProgramaVoluntariado();
            prog.setId(progId);
            service.eliminarPrograma(p, prog);
        }
    }
    
 // CORREÇÃO: o endpoint passa a devolver uma LISTA
    @GetMapping("/programas")
    public List<ProgramaVoluntariadoDTO> listarProgramas() {
        return service.listarProgramas();
    }
}//fim classe

