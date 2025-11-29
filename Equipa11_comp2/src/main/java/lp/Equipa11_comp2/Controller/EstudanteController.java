package lp.Equipa11_comp2.Controller;
/**
 * @author beatriz silva
 */

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lp.Equipa11_comp2.DTO.EstudanteDTO;
import lp.Equipa11_comp2.Entity.*;
import lp.Equipa11_comp2.Mapper.EstudanteMapper;
import lp.Equipa11_comp2.Service.*;

import java.util.List;
@RestController
@RequestMapping("/estudante")
public class EstudanteController {
	
	@Autowired
	private EstudanteService service;
	
	@Autowired
	private EstudanteMapper mapper;
	
	@Autowired
    private ProgramaEstudanteService programaService;
	
	//registar estudante
    @PostMapping("/registar")
    public ResponseEntity<?> registar(@RequestBody EstudanteDTO dto) {
        ProgramaEstudante programa = programaService.buscarPorId(dto.getIdPrograma());
        Estudante e = mapper.toEntity(dto, programa);
        Estudante salvo = service.registar(e);
        return ResponseEntity.ok(mapper.toDTO(salvo));
    }
    
    //estudante candadata-se
    @PostMapping("/{id}/candidatar")
    public ResponseEntity<?> candidatar(@PathVariable Long id, @RequestBody Candidatura c) {
        Estudante e = service.registar(service.repo.findById(id).orElse(null));
        service.candidatar(e, c);
        return ResponseEntity.ok("Candidatura efetuada!");
    }
    
    //ver estado das candidaturas
    @GetMapping("/{id}/candidaturas")
    public ResponseEntity<?> verEstado(@PathVariable Long id) {
        List<Candidatura> lista = service.verEstado(id);
        return ResponseEntity.ok(lista);
    }
    
    //imprimir todos os estudantes
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

}//fim classe
