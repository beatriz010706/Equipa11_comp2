package lp.Equipa11_comp2.Service;
/**
 * @author gonçalo silva
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lp.Equipa11_comp2.Entity.Candidatura;
import lp.Equipa11_comp2.Entity.Estado;
import lp.Equipa11_comp2.Entity.Estudante;
import lp.Equipa11_comp2.Entity.ProgramaVoluntariado;
import lp.Equipa11_comp2.Repository.CandidaturaRepository;
import lp.Equipa11_comp2.Repository.EstudanteRepository;
import lp.Equipa11_comp2.Repository.ProgramaVoluntariadoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository candidaturaRepo;

    @Autowired
    private EstudanteRepository estudanteRepo;

    @Autowired
    private ProgramaVoluntariadoRepository programaRepo;

    public Candidatura criarCandidatura(Long estudanteId, Long programaId) {
        Optional<Estudante> oe = estudanteRepo.findById(estudanteId);
        Optional<ProgramaVoluntariado> op = programaRepo.findById(programaId);

        if (oe.isEmpty() || op.isEmpty()) return null;

        Estudante e = oe.get();
        ProgramaVoluntariado p = op.get();

        if (p.getVagas() <= p.getVagasOcupadas()) {
            return null;
        }

        Candidatura c = new Candidatura();
        c.setEstudante(e);
        c.setProgramaVoluntariado(p);
        c.setDataSubmissao(LocalDate.now().toString());
        c.setEstado(Estado.EM_ANDAMENTO);

        candidaturaRepo.save(c);
        return c;
    }

    public List<Candidatura> listarPorEstudante(Long estudanteId) {
        return candidaturaRepo.findByEstudante_IdUtilizador(estudanteId);
    }

    public List<Candidatura> listarPorPrograma(Long programaId) {
        return candidaturaRepo.findByProgramaVoluntariado_Id(programaId);
    }

    public Candidatura getById(Long id) {
        return candidaturaRepo.findById(id).orElse(null);
    }

    public boolean aprovarCandidatura(Long id) {
        Optional<Candidatura> oc = candidaturaRepo.findById(id);
        if (oc.isEmpty()) return false;

        Candidatura c = oc.get();
        c.setEstado(Estado.ACEITE);

        ProgramaVoluntariado p = c.getProgramaVoluntariado();
        if (p != null) {
            p.setVagasOcupadas(p.getVagasOcupadas() + 1);
            programaRepo.save(p);
        }

        candidaturaRepo.save(c);
        return true;
    }

    public boolean rejeitarCandidatura(Long id) {
        Optional<Candidatura> oc = candidaturaRepo.findById(id);
        if (oc.isEmpty()) return false;

        Candidatura c = oc.get();
        c.setEstado(Estado.REJEITADA);
        candidaturaRepo.save(c);
        return true;
    }

    public List<Candidatura> listarTodas() {
        return candidaturaRepo.findAll();
    }
}//fim classe
