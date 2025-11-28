package lp.Equipa11_comp2.Entity;
/**
 * @author beatriz silva 
 */

import jakarta.persistence.*;
@Entity
@Table(name = "estudante")
@PrimaryKeyJoinColumn(name = "id_estudante")
public class Estudante extends Utilizador {
	private int numeroEstudante;
    private String curso;

    public Estudante() {}

    public Estudante(String nome, int idade, String email, String password, int numeroEstudante, String curso) {
        super(nome, idade, email, password);
        this.numeroEstudante = numeroEstudante;
        this.curso = curso;
    }

    public int getNumeroEstudante() { return numeroEstudante; }
    public String getCurso() { return curso; }
    public void setNumeroEstudante(int numeroEstudante) { this.numeroEstudante = numeroEstudante; }
    public void setCurso(String curso) { this.curso = curso; }

}//fim da classe
