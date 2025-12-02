package lp.Equipa11_comp2.Entity;
/**
 * @author gonçalo silva
 */
import jakarta.persistence.*;

/**
 * Entidade Candidatura
 */
@Entity
@Table(name = "candidatura")
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCandidatura;

    // Para simplificar usamos String para a data (podes mudar para LocalDate se preferires)
    private String dataSubmissao;

    @ManyToOne
    @JoinColumn(name = "id_estudante")
    private Estudante estudante;

    @ManyToOne
    @JoinColumn(name = "id_programa")
    private ProgramaVoluntariado programaVoluntariado;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public Candidatura() { }

    public Candidatura(String dataSubmissao, Estudante estudante, ProgramaVoluntariado programaVoluntariado, Estado estado) {
        this.dataSubmissao = dataSubmissao;
        this.estudante = estudante;
        this.programaVoluntariado = programaVoluntariado;
        this.estado = estado;
    }

    // Getters / Setters
    public Long getIdCandidatura() { return idCandidatura; }

    public String getDataSubmissao() { return dataSubmissao; }
    public void setDataSubmissao(String dataSubmissao) { this.dataSubmissao = dataSubmissao; }

    public Estudante getEstudante() { return estudante; }
    public void setEstudante(Estudante estudante) { this.estudante = estudante; }

    public ProgramaVoluntariado getProgramaVoluntariado() { return programaVoluntariado; }
    public void setProgramaVoluntariado(ProgramaVoluntariado programaVoluntariado) { this.programaVoluntariado = programaVoluntariado; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    @Override
    public String toString() {
        String prog = (programaVoluntariado != null) ? programaVoluntariado.getTitulo() : "null";
        String estu = (estudante != null) ? estudante.getNome() : "null";
        return "Candidatura{id=" + idCandidatura +
               ", data=" + dataSubmissao +
               ", estudante=" + estu +
               ", programa=" + prog +
               ", estado=" + estado + "}";
    }
}
