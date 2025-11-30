package lp.Equipa11_comp2.Mapper;

import lp.Equipa11_comp2.DTO.EstadoDTO;
import lp.Equipa11_comp2.Entity.Estado;

public class EstadoMapper {
	
	public EstadoDTO toDTO (Estado e) {
		if(e == null) {
			return null;
		}
		return new EstadoDTO(e.getIdEstado(), e.getEstado());
	}
	
	public Estado toEntity(EstadoDTO dto) {
		if(dto == null) {
			return null;
		}
		Estado e = new Estado();
		e.setEstado(dto.getEstado());
		return e;
	}
}
