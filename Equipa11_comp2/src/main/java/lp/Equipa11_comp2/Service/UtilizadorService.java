package lp.Equipa11_comp2.Service;
/**
 * @author beatriz silva 
 */
import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Service;

import lp.Equipa11_comp2.DTO.*;
import lp.Equipa11_comp2.Entity.*;
import lp.Equipa11_comp2.Mapper.*;
import lp.Equipa11_comp2.Repository.*;

import java.util.List;
import java.util.Optional;

// Service = camada onde fica a lógica do programa
// Aqui não tratamos de HTTP, nem de DTOs. Só regras de negócio.
@Service
public class UtilizadorService {

    @Autowired
    private UtilizadorRepository repo;
    
    @Autowired
    private EstudanteRepository estudanteRepo;

    @Autowired
    private ParceiroRepository parceiroRepo;

    @Autowired
    private UtilizadorMapper mapper;
    
    @Autowired
    private CandidaturaRepository candidaturaRepo;
    
    public Utilizador registar(UtilizadorDTO dto) {
        Utilizador u = mapper.toEntity(dto);

        if(u instanceof Estudante) {
            return estudanteRepo.save((Estudante) u);
        } else if(u instanceof Parceiro) {
            return parceiroRepo.save((Parceiro) u);
        } else {
            return repo.save(u);
        }
    }
    
 // login básico
    public Utilizador login(String email, String password) {
        Optional<Utilizador> user = repo.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null; // se não existir ou password errada
    }

    // Método para consultar o histórico de candidaturas
    public String consultarHistoricoCandidaturas(Long idUtilizador) {

        // 1 — Procurar o utilizador
        Optional<Utilizador> userOpt = repo.findById(idUtilizador);

        if (userOpt.isEmpty()) {
            return "Utilizador não encontrado.";
        }

        Utilizador user = userOpt.get();

        // 2 — Garantir que é um estudante (só eles têm candidaturas)
        if (!(user instanceof Estudante estudante)) {
            return "Apenas estudantes têm histórico de candidaturas.";
        }

        // 3 — Buscar as candidaturas do estudante
        List<Candidatura> candidaturas = candidaturaRepo.findByEstudante(estudante);

        if (candidaturas.isEmpty()) {
            return "O estudante não tem candidaturas registadas.";
        }

        // 4 — Construir o histórico
        StringBuilder sb = new StringBuilder();
        sb.append("Histórico de candidaturas do estudante ").append(estudante.getNome()).append(":\n\n");

        for (Candidatura c : candidaturas) {
            sb.append("• Programa: ").append(c.getProgramaVoluntariado().getNomePrograma()).append("\n")
              .append("  Data: ").append(c.getDataSubmissao()).append("\n")
              .append("  Estado: ").append(c.getEstado().getEstado()).append("\n\n");
        }

        return sb.toString();
    }

    
}//fim da classe
