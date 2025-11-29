package lp.Equipa11_comp2.Service;
/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import lp.Equipa11_comp2.DTO.UtilizadorDTO;
import lp.Equipa11_comp2.Entity.Estudante;
import lp.Equipa11_comp2.Entity.Parceiro;
import lp.Equipa11_comp2.Entity.Utilizador;
import lp.Equipa11_comp2.Mapper.UtilizadorMapper;
import lp.Equipa11_comp2.Repository.EstudanteRepository;
import lp.Equipa11_comp2.Repository.ParceiroRepository;
import lp.Equipa11_comp2.Repository.UtilizadorRepository;
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
    // ACABAR
    public String consultarHistoricoCandidaturas(Long idUtilizador) {
        // Quando criares a entidade Candidatura, pesquisamos por ela
        return "Funcionalidade pendente — falta entidade Candidatura.";
    }

    
}//fim da classe
