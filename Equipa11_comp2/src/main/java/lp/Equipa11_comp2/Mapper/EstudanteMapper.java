package lp.Equipa11_comp2.Mapper;
/**
 * @author beatriz silva
 */

import org.springframework.stereotype.Component;
import lp.Equipa11_comp2.DTO.EstudanteDTO;
import lp.Equipa11_comp2.Entity.*;

@Component
public class EstudanteMapper {

	//DTO -> Entity
	public Estudante toEntity(EstudanteDTO dto, ProgramaEstudante programa) {
        Estudante e = new Estudante();
        e.setNome(dto.getNome());
        e.setIdade(dto.getIdade());
        e.setEmail(dto.getEmail());
        e.setNumeroEstudante(dto.getNumeroEstudante());
        e.setCurso(dto.getCurso());
        e.setPrograma(programa);
        return e;
    }
	
	// Entity -> DTO
    public EstudanteDTO toDTO(Estudante e) {
        EstudanteDTO dto = new EstudanteDTO();
        dto.setId(e.getIdUtilizador());
        dto.setNome(e.getNome());
        dto.setIdade(e.getIdade());
        dto.setEmail(e.getEmail());
        dto.setNumeroEstudante(e.getNumeroEstudante());
        dto.setCurso(e.getCurso());
        if (e.getPrograma() != null) {
            dto.setIdPrograma(e.getPrograma().getIdPrograma());
        }
        return dto;
    }
}//fim classe
