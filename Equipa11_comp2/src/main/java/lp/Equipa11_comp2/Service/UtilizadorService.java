package lp.Equipa11_comp2.Service;
/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lp.Equipa11_comp2.Entity.Utilizador;
import lp.Equipa11_comp2.Repository.UtilizadorRepository;
import java.util.List;
import java.util.Optional;

// Service = camada onde fica a lógica do programa
// Aqui não tratamos de HTTP, nem de DTOs. Só regras de negócio.
@Service
public class UtilizadorService {

    @Autowired
    private UtilizadorRepository repo;

    // Método para registar um novo utilizador
    public Utilizador registar(Utilizador utilizador) {
        // Aqui podias validar password, idade mínima, etc…
        return repo.save(utilizador);
    }

    // Método para consultar o histórico de candidaturas
    // COMO NÃO NOS DESTE A ENTIDADE Candidatura, deixo preparado
    public String consultarHistoricoCandidaturas(Long idUtilizador) {
        // Quando criares a entidade Candidatura, pesquisamos por ela
        return "Funcionalidade pendente — falta entidade Candidatura.";
    }

    // Extra: login básico
    public Utilizador login(String email, String password) {
        Optional<Utilizador> user = repo.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        }
        return null; // se não existir ou password errada
    }
}//fim da classe
