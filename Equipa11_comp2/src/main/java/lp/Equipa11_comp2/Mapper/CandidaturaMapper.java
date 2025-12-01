package lp.Equipa11_comp2.Mapper;

import org.springframework.stereotype.Component;
import lp.Equipa11_comp2.DTO.CandidaturaDTO;
import lp.Equipa11_comp2.Entity.Candidatura;
import lp.Equipa11_comp2.Entity.Estado;

@Component
public class CandidaturaMapper {

    public CandidaturaDTO toDTO(Candidatura c) {
        if (c == null) return null;
        Long estudanteId = (c.getEstudante() != null) ? c.getEstudante().getIdUtilizador() : null;
        Long programaId = (c.getProgramaVoluntariado() != null) ? c.getProgramaVoluntariado().getId() : null;

        return new CandidaturaDTO(c.getIdCandidatura(),
                                  c.getDataSubmissao(),
                                  estudanteId,
                                  programaId,
                                  c.getEstado());
    }

    /**
     * Converte DTO → entity básica. Não resolve relações (estudante, programa).
     * O serviço deve ligar estudante e programa usando os IDs do DTO.
     */
    public Candidatura fromDTO(CandidaturaDTO dto) {
        if (dto == null) return null;
        Candidatura c = new Candidatura();
        c.setDataSubmissao(dto.getDataSubmissao());
        c.setEstado(dto.getEstado() != null ? dto.getEstado() : Estado.EM_ANDAMENTO);
        // estudante e programa serão atribuídos no service através dos ids
        return c;
    }
}

