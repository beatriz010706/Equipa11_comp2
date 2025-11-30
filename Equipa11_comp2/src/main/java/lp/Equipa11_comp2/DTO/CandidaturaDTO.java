package lp.Equipa11_comp2.DTO;

import lp.Equipa11_comp2.Entity.Estado;
import lp.Equipa11_comp2.Entity.Estudante;
import lp.Equipa11_comp2.Entity.ProgramaVoluntariado;


public class CandidaturaDTO {
	private long idCandidatura;
	private String dataSubmissao;
	private Estudante estudante;
	private ProgramaVoluntariado programaVoluntariado;
	private Estado.EstadoEnum estado;
	
	public CandidaturaDTO() {}

	/**
	 * @param idCandidatura
	 * @param dataSubmissao
	 * @param estudante
	 * @param estado
	 */
	public CandidaturaDTO(long idCandidatura, String dataSubmissao, Estudante estudante,ProgramaVoluntariado programaVoluntariado ,Estado.EstadoEnum estado) {
		this.idCandidatura = idCandidatura;
		this.dataSubmissao = dataSubmissao;
		this.estudante = estudante;
		this.programaVoluntariado = programaVoluntariado;
		this.estado = estado;
	}

	public long getIdCandidatura() {
		return idCandidatura;
	}

	public void setIdCandidatura(long idCandidatura) {
		this.idCandidatura = idCandidatura;
	}

	public String getDataSubmissao() {
		return dataSubmissao;
	}

	public void setDataSubmissao(String dataSubmissao) {
		this.dataSubmissao = dataSubmissao;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	

	public ProgramaVoluntariado getProgramaVoluntariado() {
		return programaVoluntariado;
	}

	public void setProgramaVoluntariado(ProgramaVoluntariado programaVoluntariado) {
		this.programaVoluntariado = programaVoluntariado;
	}

	public Estado.EstadoEnum getEstado() {
		return estado;
	}

	public void setEstado(Estado.EstadoEnum estado) {
		this.estado = estado;
	}
}
