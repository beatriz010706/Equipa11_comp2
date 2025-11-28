package lp.Equipa11_comp2.Controller;
/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lp.Equipa11_comp2.DTO.UtilizadorDTO;
import lp.Equipa11_comp2.Entity.Utilizador;
import lp.Equipa11_comp2.Mapper.UtilizadorMapper;
import lp.Equipa11_comp2.Service.UtilizadorService;

// Controller = recebe pedidos HTTP e devolve respostas.
// Aqui usamos o Service + Mapper para criar o fluxo completo.
@RestController
@RequestMapping("/utilizador")
public class UtilizadorController {

    @Autowired
    private UtilizadorService service;

    @Autowired
    private UtilizadorMapper mapper;

    // Endpoint para registar um utilizador
    @PostMapping("/registar")
    public ResponseEntity<?> registar(@RequestBody Utilizador dto) {
        Utilizador novo = service.registar(dto);
        return ResponseEntity.ok(mapper.toDTO(novo));
    }

    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        Utilizador u = service.login(email, password);

        if (u == null) {
            return ResponseEntity.status(401).body("Email ou password incorretos");
        }

        return ResponseEntity.ok(mapper.toDTO(u));
    }

    // Endpoint para consultar histórico de candidaturas
    @GetMapping("/{id}/historico")
    public ResponseEntity<?> historico(@PathVariable Long id) {
        return ResponseEntity.ok(service.consultarHistoricoCandidaturas(id));
    }
}
