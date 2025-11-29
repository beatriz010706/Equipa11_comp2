package lp.Equipa11_comp2.Service;
/**
 * @author beatriz silva
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lp.Equipa11_comp2.Entity.*;
import lp.Equipa11_comp2.Repository.*;
import java.util.List;

@Service
public class ParceiroService {

    @Autowired
    private ProgramaVoluntariadoRepository programaRepo;

    @Autowired
    private CandidaturaRepository candidaturaRepo;
    
    @Autowired
    private EstadoRepository estadoRepo;

    @Autowired
    private CandidaturaRepository candidaturaRepo;

    // REGISTAR PROGRAMA
    public ProgramaVoluntariado registarPrograma(Long idParceiro, ProgramaVoluntariado p) {
        Parceiro parceiro = parceiroRepo.findById(idParceiro).orElseThrow();
        p.setParceiro(parceiro);
        return programaRepo.save(p);
    }

    // EDITAR PROGRAMA
    public ProgramaVoluntariado editarPrograma(Long idPrograma, String novoNome, int novasHoras) {
        ProgramaVoluntariado p = programaRepo.findById(idPrograma).orElseThrow();
        p.setNomePrograma(novoNome);
        p.setHorasTotais(novasHoras);
        return programaRepo.save(p);
    }

    // ELIMINAR PROGRAMA
    public void eliminarPrograma(Long idPrograma) {
        programaRepo.deleteById(idPrograma);
    }

    // APROVAR CANDIDATURA
    public void aprovarCandidatura(Long idCandidatura) {
        Candidatura c = candidaturaRepo.findById(idCandidatura).orElseThrow();
        
        Estado estadoAprovado = new Estado(Estado.EstadoEnum.ACEITE);
        estadoRepo.save(estadoAprovado);

        c.setEstado(estadoAprovado);
        candidaturaRepo.save(c);
    }

    // REJEITAR CANDIDATURA
    public void rejeitarCandidatura(Long idCandidatura) {
        Candidatura c = candidaturaRepo.findById(idCandidatura).orElseThrow();
        
        Estado estadoRejeitado = new Estado(Estado.EstadoEnum.REJEITADA);
        estadoRepo.save(estadoRejeitado);

        c.setEstado(estadoRejeitado);
        candidaturaRepo.save(c);
    }
}//fim classe