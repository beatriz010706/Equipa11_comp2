package lp.Equipa11_comp2.Controller;
/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lp.Equipa11_comp2.DTO.*;
import lp.Equipa11_comp2.Entity.*;
import lp.Equipa11_comp2.Mapper.*;
import lp.Equipa11_comp2.Service.*;

import java.util.List;

@RestController
@RequestMapping("/parceiro")
public class ParceiroController {

    @Autowired
    private ParceiroService service;

    @Autowired
    private TipoService tipoService;

    @Autowired
    private ParceiroMapper mapper;

    // Registar parceiro
    @PostMapping("/registar")
    public ResponseEntity<?> registar(@RequestBody ParceiroDTO dto) {
        Tipo tipo = tipoService.buscarPorId(dto.getIdTipo());
        Parceiro p = mapper.toEntity(dto, tipo);
        return ResponseEntity.ok(mapper.toDTO(service.registar(p)));
    }

    // Registar programa
    @PostMapping("/{id}/programa/registar")
    public ResponseEntity<?> registarPrograma(@PathVariable Long id,
                                              @RequestBody ProgramaVoluntariado p) {
        service.registarPrograma(id, p);
        return ResponseEntity.ok("Programa registado!");
    }

    // Editar programa
    @PostMapping("/{id}/programa/editar")
    public ResponseEntity<?> editarPrograma(@RequestBody ProgramaVoluntariado p,
                                            @RequestParam String nome,
                                            @RequestParam int horasTotais) {
        service.editarPrograma(p, nome, horasTotais);
        return ResponseEntity.ok("Programa editado!");
    }

    // Eliminar programa
    @PostMapping("/{id}/programa/eliminar")
    public ResponseEntity<?> eliminarPrograma(@PathVariable Long id,
                                              @RequestBody ProgramaVoluntariado p) {
        service.eliminarPrograma(id, p);
        return ResponseEntity.ok("Programa eliminado!");
    }

    // Aprovar candidatura
    @PostMapping("/candidatura/aprovar")
    public ResponseEntity<?> aprovar(@RequestBody Candidatura c) {
        service.aprovarCandidatura(c);
        return ResponseEntity.ok("Candidatura aprovada!");
    }

    // Rejeitar candidatura
    @PostMapping("/candidatura/rejeitar")
    public ResponseEntity<?> rejeitar(@RequestBody Candidatura c) {
        service.rejeitarCandidatura(c);
        return ResponseEntity.ok("Candidatura rejeitada!");
    }

    // Listar todos os parceiros
    @GetMapping("/listar")
    public ResponseEntity<List<Parceiro>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}//fim classe
