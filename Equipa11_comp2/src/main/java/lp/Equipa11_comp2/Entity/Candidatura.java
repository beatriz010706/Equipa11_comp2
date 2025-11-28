package lp.Equipa11_comp2.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Candidatura")
public class Candidatura {

    // ====== FIELDS ======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCandidatura;  // Primary Key

    private String dataSubmissao;

    @ManyToOne
    @JoinColumn(name = "idEstudante")  // FK to Estudante
    private Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "idProgVoluntariado")  // FK to ProgramaVoluntariado
    private ProgramaVoluntariado programaVoluntariado;

    @ManyToOne
    @JoinColumn(name = "idEstado")  // FK to Estado
    private Estado estado;

    // ====== CONSTRUCTORS ======
    public Candidatura() { }

    public Candidatura(long idCandidatura, String dataSubmissao, Estudante estudante, ProgramaVoluntariado programaVoluntariado, Estado estado) {
        this.idCandidatura = idCandidatura;
        this.dataSubmissao = dataSubmissao;
        this.estudante = estudante;
        this.programaVoluntariado = programaVoluntariado;
        this.estado = estado;
    }

    // ====== GETTERS & SETTERS ======
    public long getIdCandidatura() {
        return idCandidatura;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

	@Override
	public String toString() {
		return "Candidatura [idCandidatura=" + idCandidatura + ", dataSubmissao=" + dataSubmissao + ", estudante="
				+ estudante + ", estado=" + estado + "]";
	}
    
    

}
