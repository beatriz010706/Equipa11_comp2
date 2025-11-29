package lp.Equipa11_comp2.Entity;
/**
 * @author beatriz silva 
 */

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "estudante")
@PrimaryKeyJoinColumn(name = "id_estudante")
public class Estudante extends Utilizador {

    private int numeroEstudante;
    private String curso;

    // Lista de candidaturas associadas ao estudante
    @OneToMany(mappedBy = "estudante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Candidatura> candidaturas = new ArrayList<>();

    // Lista de programas de voluntariado associados ao estudante
    @ManyToOne
    @JoinColumn(name = "id_programa") // coluna na tabela estudante
    private ProgramaEstudante programa;
    private List<ProgramaEstudante> programas = new ArrayList<>();

    // Construtor vazio (necessário para JPA)
    public Estudante() {}

    // Construtor completo incluindo campos herdados e específicos
    public Estudante(String nome, int idade, String email, String password,
                     int numeroEstudante, String curso) {
        super(nome, idade, email, password);
        this.numeroEstudante = numeroEstudante;
        this.curso = curso;
    }

    // Getters e Setters
    public int getNumeroEstudante() { return numeroEstudante; }
    public void setNumeroEstudante(int numeroEstudante) { this.numeroEstudante = numeroEstudante; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public List<Candidatura> getCandidaturas() { return candidaturas; }
    public void setCandidaturas(List<Candidatura> candidaturas) { this.candidaturas = candidaturas; }

    public List<ProgramaEstudante> getProgramas() { return programas; }
    public void setProgramas(List<ProgramaEstudante> programas) { this.programas = programas; }

    // Métodos auxiliares para adicionar elementos às listas
    public void addCandidatura(Candidatura c) {
        candidaturas.add(c);
        c.setEstudante(this);
    }

    public void addPrograma(ProgramaEstudante p) {
        programas.add(p);
    }

}//fim da classe
