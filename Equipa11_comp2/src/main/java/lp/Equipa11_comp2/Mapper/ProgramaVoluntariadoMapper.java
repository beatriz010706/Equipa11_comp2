package lp.Equipa11_comp2.Mapper;

/**
 * @author miguel silva
 */

import org.springframework.stereotype.Component;
import lp.Equipa11_comp2.DTO.ProgramaVoluntariadoDTO;
import lp.Equipa11_comp2.Entity.ProgramaVoluntariado;

@Component
public class ProgramaVoluntariadoMapper {

    public ProgramaVoluntariadoDTO toDTO(ProgramaVoluntariado p) {
        return new ProgramaVoluntariadoDTO(
            p.getId(),
            p.getTitulo(),
            p.getDescricao(),
            p.getHorasServico(),
            p.getLocal(),
            p.getVagas(),
            p.getVagasOcupadas()
        );
    }

    public ProgramaVoluntariado toEntity(ProgramaVoluntariadoDTO dto) {
        ProgramaVoluntariado p = new ProgramaVoluntariado(
            dto.getTitulo(),
            dto.getDescricao(),
            dto.getHorasServico(),
            dto.getLocal(),
            dto.getVagas()
        );
        p.setVagasOcupadas(dto.getVagasOcupadas());
        return p;
    }
}//fim classe
