package lp.Equipa11_comp2.Mapper;

import org.springframework.stereotype.Component;
import lp.Equipa11_comp2.Entity.Candidatura;
import lp.Equipa11_comp2.DTO.CandidaturaDTO;


@Component
public class CandidaturaMapper {
	
	public CandidaturaDTO toDTO (Candidatura c) {
		if (c==null) {return null;}
		return new CandidaturaDTO(c.getIdCandidatura(),c.getDataSubmissao(),c.getEstudante(),c.getProgramaVoluntariado(),c.getEstado());
	}
	
	public Candidatura toEntity(CandidaturaDTO dto) {
		if (dto==null) {return null;}
		Candidatura c = new Candidatura();
		c.setDataSubmissao(c.getDataSubmissao());
		c.setEstudante(c.getEstudante());
		c.setProgramaVoluntariado(c.getProgramaVoluntariado());
		c.setEstado(c.getEstado());
		return c;
	}
}
