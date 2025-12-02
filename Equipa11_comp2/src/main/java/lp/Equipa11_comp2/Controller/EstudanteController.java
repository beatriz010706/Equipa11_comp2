package lp.Equipa11_comp2.Controller;
/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lp.Equipa11_comp2.DTO.*;
import lp.Equipa11_comp2.Service.*;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService service;

    @PostMapping("/registar")
    public EstudanteDTO registar(@RequestBody EstudanteDTO dto) {
        return service.registar(dto);
    }

    @PostMapping("/login")
    public EstudanteDTO login(@RequestBody EstudanteDTO dto) {
        return service.login(dto.getEmail(), dto.getPassword());
    }


    @GetMapping("/{id}/historico")
    public String consultarHistorico(@PathVariable Long id) {
        return service.consultarHistorico(id);
    }
}
