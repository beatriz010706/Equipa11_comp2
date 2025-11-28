package lp.Equipa11_comp2.Entity;

import jakarta.persistence.*;

public class Estado {

	public enum EstadoEnum{
		ACEITE,
		EM_ANDAMENTO,
		REJEITADA
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEstado;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;
    
    public Estado() { }

	/**
	 * @param estado
	 */
	public Estado(EstadoEnum estado) {
		this.estado = estado;
	}

	public long getIdEstado() {
		return idEstado;
	}

	public EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Estado [id=" + idEstado + ", estado=" + estado + "]";
	}
    
    
}
