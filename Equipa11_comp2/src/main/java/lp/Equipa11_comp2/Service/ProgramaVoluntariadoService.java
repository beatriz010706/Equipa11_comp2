package lp.Equipa11_comp2.Service;

/**
 * @author miguel silva
 */

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import lp.Equipa11_comp2.Entity.ProgramaVoluntariado;
import lp.Equipa11_comp2.DTO.ParceiroDTO;
import lp.Equipa11_comp2.Entity.*;
import lp.Equipa11_comp2.Repository.ProgramaVoluntariadoRepository;
import lp.Equipa11_comp2.Repository.CandidaturaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramaVoluntariadoService {

    @Autowired
    private ProgramaVoluntariadoRepository repo;

    @Autowired
    private CandidaturaRepository candidaturaRepo;
    
    
    
 // Inserir candidatura
    public void inserirCandidatura(ProgramaVoluntariado p, Candidatura c) {
        if (verificarVagasDisponiveis(p)) {
            p.getCandidaturas().add(c);
            c.setProgramaVoluntariado(p);
            repo.save(p);
            candidaturaRepo.save(c);
        }
    }

    // Listar candidaturas pendentes
    public List<Candidatura> listarCandidaturasPendentes(ProgramaVoluntariado p) {
        List<Candidatura> pendentes = new ArrayList<>();
        for (Candidatura c : p.getCandidaturas()) {
            if (c.getEstado() == Estado.EM_ANDAMENTO) {
                pendentes.add(c);
            }
        }
        return pendentes;
    }

    // Verificar vagas disponíveis
    public boolean verificarVagasDisponiveis(ProgramaVoluntariado p) {
        return p.getVagasOcupadas() < p.getVagas();
    }

    // Listar participantes aprovados
    public List<Candidatura> listarParticipantes(ProgramaVoluntariado p) {
        List<Candidatura> aprovados = new ArrayList<>();
        for (Candidatura c : p.getCandidaturas()) {
        	if (c.getEstado() == Estado.ACEITE) {
                aprovados.add(c);
            }
        }
        return aprovados;
    }

}