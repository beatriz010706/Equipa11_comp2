package lp.Equipa11_comp2.Service;
/**
 * @author diogo garcia 
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lp.Equipa11_comp2.Entity.ProgramaEstudante;
import lp.Equipa11_comp2.Repository.ProgramaEstudanteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramaEstudanteService {

    @Autowired
    private ProgramaEstudanteRepository repo;

    // Guardar programa
    public ProgramaEstudante salvarPrograma(ProgramaEstudante p) {
        return repo.save(p);
    }

    // Listar todos
    public List<ProgramaEstudante> listarProgramas() {
        return repo.findAll();
    }

    // Buscar por ID
    public ProgramaEstudante getById(Long id) {
        Optional<ProgramaEstudante> p = repo.findById(id);
        return p.orElse(null);
    }

    // Adicionar horas feitas
    public void adicionarHoras(Long id, int horas) {
        ProgramaEstudante p = getById(id);
        if (p != null) {
            p.adicionarHoras(horas);
            repo.save(p);
        }
    }

    // Concluir programa
    public void concluirPrograma(Long id) {
        ProgramaEstudante p = getById(id);
        if (p != null) {
            p.concluirPrograma();
            repo.save(p);
        }
    }

    // Emitir diploma
    public boolean emitirDiploma(Long id) {
        ProgramaEstudante p = getById(id);
        if (p != null) {
            boolean emitido = p.emitirDiploma();
            repo.save(p);
            return emitido;
        }
        return false;
    }

    // Percentagem de progresso
    public double getProgresso(Long id) {
        ProgramaEstudante p = getById(id);
        if (p != null) {
            return p.getProgresso();
        }
        return 0;
    }

    // Cancelar participação
    public void cancelarParticipacao(Long id) {
        ProgramaEstudante p = getById(id);
        if (p != null) {
            p.cancelarParticipacao();
            repo.save(p);
        }
    }
}
