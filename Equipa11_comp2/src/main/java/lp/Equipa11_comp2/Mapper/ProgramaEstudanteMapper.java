package lp.Equipa11_comp2.Mapper;
/**
 * @author diogo garcia 
 */
import org.springframework.stereotype.Component;
import lp.Equipa11_comp2.DTO.ProgramaEstudanteDTO;
import lp.Equipa11_comp2.Entity.ProgramaEstudante;

@Component
public class ProgramaEstudanteMapper {

    public ProgramaEstudanteDTO toDTO(ProgramaEstudante p) {
        return new ProgramaEstudanteDTO(
            p.getId(),
            p.getDataInicio(),
            p.getDataFim(),
            p.getHorasFeitas(),
            p.isEmitirDiploma()
        );
    }

    public ProgramaEstudante toEntity(ProgramaEstudanteDTO dto) {
        ProgramaEstudante p = new ProgramaEstudante();
        p.setDataInicio(dto.getDataInicio());
        p.setDataFim(dto.getDataFim());
        p.setHorasFeitas(dto.getHorasFeitas());
        p.setEmitirDiploma(dto.isEmitirDiploma());
        return p;
    }
}//fim classe
