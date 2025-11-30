package lp.Equipa11_comp2.DTO;

import lp.Equipa11_comp2.Entity.Estado.EstadoEnum;

public class EstadoDTO {
	private long idEstado;
	private EstadoEnum estado;
	
	public EstadoDTO() {}

	/**
	 * @param idEstado
	 * @param estado
	 */
	public EstadoDTO(long idEstado, EstadoEnum estado) {
		this.idEstado = idEstado;
		this.estado = estado;
	}

	public long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(long idEstado) {
		this.idEstado = idEstado;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}
}
