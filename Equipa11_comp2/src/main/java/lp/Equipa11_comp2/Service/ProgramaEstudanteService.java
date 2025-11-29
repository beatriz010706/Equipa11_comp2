package lp.Equipa11_comp2.Service;
/**
 * @author diogo garcia
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lp.Equipa11_comp2.Entity.ProgramaEstudante;
import lp.Equipa11_comp2.Repository.ProgramaEstudanteRepository;
import java.util.List;

@Service
public class ProgramaEstudanteService {

    @Autowired
    private ProgramaEstudanteRepository repo;

    public ProgramaEstudante salvarPrograma(ProgramaEstudante p) {
        return repo.save(p);
    }

    public List<ProgramaEstudante> listarProgramas() {
        return repo.findAll();
    }

    public void adicionarHoras(ProgramaEstudante p, int horas) {
        p.adicionarHoras(horas);
        repo.save(p);
    }

    public void concluirPrograma(ProgramaEstudante p) {
        p.concluirPrograma();
        repo.save(p);
    }

    public boolean emitirDiploma(ProgramaEstudante p) {
        return p.emitirDiploma();
    }

    public double getProgresso(ProgramaEstudante p) {
        return p.getProgresso();
    }

    public void cancelarParticipacao(ProgramaEstudante p) {
        p.cancelarParticipacao();
        repo.save(p);
    }
}
