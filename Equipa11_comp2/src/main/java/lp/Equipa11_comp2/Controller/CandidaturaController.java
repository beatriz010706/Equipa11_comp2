package lp.Equipa11_comp2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lp.Equipa11_comp2.Entity.Candidatura;
import lp.Equipa11_comp2.DTO.CandidaturaDTO;
import lp.Equipa11_comp2.Mapper.CandidaturaMapper;
import lp.Equipa11_comp2.Service.CandidaturaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidaturas")
public class CandidaturaController {

    @Autowired
    private CandidaturaService service;

    @Autowired
    private CandidaturaMapper mapper;

    // Criar candidatura (body com estudanteId e programaId ou usar params)
    @PostMapping("/criar")
    public CandidaturaDTO criar(@RequestBody CandidaturaDTO dto) {
        Candidatura c = service.criarCandidatura(dto.getEstudanteId(), dto.getProgramaId());
        return mapper.toDTO(c);
    }

    // Listar candidaturas de um estudante
    @GetMapping("/estudante/{id}")
    public List<CandidaturaDTO> listarPorEstudante(@PathVariable Long id) {
        return service.listarPorEstudante(id)
                      .stream()
                      .map(mapper::toDTO)
                      .collect(Collectors.toList());
    }

    // Listar candidaturas de um programa
    @GetMapping("/programa/{id}")
    public List<CandidaturaDTO> listarPorPrograma(@PathVariable Long id) {
        return service.listarPorPrograma(id)
                      .stream()
                      .map(mapper::toDTO)
                      .collect(Collectors.toList());
    }

    // Aprovar candidatura
    @PostMapping("/{id}/aprovar")
    public String aprovar(@PathVariable Long id) {
        boolean ok = service.aprovarCandidatura(id);
        return ok ? "Aprovada" : "Não encontrada";
    }

    // Rejeitar candidatura
    @PostMapping("/{id}/rejeitar")
    public String rejeitar(@PathVariable Long id) {
        boolean ok = service.rejeitarCandidatura(id);
        return ok ? "Rejeitada" : "Não encontrada";
    }

    // Listar todas (admin / dev)
    @GetMapping("/todas")
    public List<CandidaturaDTO> todas() {
        return service.listarTodas().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
}
