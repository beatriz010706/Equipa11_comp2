package lp.Equipa11_comp2.Entity;
/**
 * @author beatriz silva
 */
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudante")
@PrimaryKeyJoinColumn(name = "id_estudante")
public class Estudante extends Utilizador {

    private int numeroAluno;
    private String curso;

    // Lista de candidaturas do estudante
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Candidatura> candidaturas = new ArrayList<>();

    // Lista de programas do estudante
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramaEstudante> programasEstudante = new ArrayList<>();

    public Estudante() {}

    public Estudante(String nome, String email, String password,
                     int numeroAluno, String curso) {
        super(nome, email, password);
        this.numeroAluno = numeroAluno;
        this.curso = curso;
    }

    // Getters e Setters
    public int getNumeroAluno() { return numeroAluno; }
    public void setNumeroAluno(int numeroAluno) { this.numeroAluno = numeroAluno; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public List<Candidatura> getCandidaturas() { return candidaturas; }
    public void setCandidaturas(List<Candidatura> candidaturas) { this.candidaturas = candidaturas; }

    public List<ProgramaEstudante> getProgramasEstudante() { return programasEstudante; }
    public void setProgramasEstudante(List<ProgramaEstudante> programasEstudante) { this.programasEstudante = programasEstudante; }
}//fim classe
