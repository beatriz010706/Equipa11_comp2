package lp.Equipa11_comp2.Service;
/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import lp.Equipa11_comp2.Entity.*;
import lp.Equipa11_comp2.Repository.EstudanteRepository;
import java.util.List;

@Service
public class EstudanteService {
	
	@Autowired
    private EstudanteRepository repo;
	
	//regista ou atualiza um estudante
    public Estudante registar(Estudante e) {
        return repo.save(e);
    }
    
    //metodo para estudante se candidatar a programa de voluntariado
    public void candidatar(Estudante e, Candidatura c) {
        e.addCandidatura(c);
        repo.save(e); // salva 
    }
    
    //ver o estado da candidatura de um estudante
    public List<Candidatura> verEstado(Long idEstudante) {
        Estudante e = repo.findById(idEstudante).orElse(null);
        if (e != null) {
            return e.getCandidaturas();
        }
        return null;
    }
    
    //imprimir todos os estudantes
    public List<Estudante> listarTodos() {
        return repo.findAll();
    }
	
}//fim classe
