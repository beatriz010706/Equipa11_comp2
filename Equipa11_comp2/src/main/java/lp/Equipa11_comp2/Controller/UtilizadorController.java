package lp.Equipa11_comp2.Controller;
/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*;

import lp.Equipa11_comp2.DTO.*;
import lp.Equipa11_comp2.Entity.*;
import lp.Equipa11_comp2.Service.*;

import java.util.List;

@RestController
@RequestMapping("/utilizadores")
public class UtilizadorController {

    @Autowired
    private UtilizadorService service;

    @PostMapping("/registar")
    public Utilizador registar(@RequestBody UtilizadorDTO dto) {
        return service.registar(dto);
    }

    @PostMapping("/login")
    public Utilizador login(@RequestParam String email,
                            @RequestParam String password) {
        return service.login(email, password);
    }

    @GetMapping("/{id}/candidaturas")
    public List<Candidatura> historico(@PathVariable Long id) {
        return service.consultarHistoricoCandidaturas(id);
    }
}

