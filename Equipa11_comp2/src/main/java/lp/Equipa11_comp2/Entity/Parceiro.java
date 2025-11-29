package lp.Equipa11_comp2.Entity;
/**
 * @author beatriz silva 
 */

import jakarta.persistence.*;
@Entity
@Table(name = "parceiro")
@PrimaryKeyJoinColumn(name = "id_parceiro")
public class Parceiro extends Utilizador {

    @ManyToOne
    @JoinColumn(name = "id_tipo") // nome da coluna na BD
    private Tipo tipo;

    private String local;

    // 1 parceiro → vários ProgramasEstudante
    @OneToMany(mappedBy = "parceiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramaEstudante> programas = new ArrayList<>();

    public Parceiro() {}

    public Parceiro(String nome, int idade, String email, String password,
                    Tipo tipo, String local) {
        super(nome, idade, email, password);
        this.tipo = tipo;
        this.local = local;
    }

    // Getters e Setters
    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public List<ProgramaEstudante> getProgramas() { return programas; }
    public void setProgramas(List<ProgramaEstudante> programas) { this.programas = programas; }

    // MÉTODOS DO PARCEIRO

    /** Registar novo programa de voluntariado */
    public void registarProgramaV(ProgramaEstudante p) {
        programas.add(p);
        p.setParceiro(this);
    }

    /** Editar dados de um programa existente */
    public void editarProgramaV(ProgramaEstudante p, String novoNome, int novasHoras) {
        p.setNomePrograma(novoNome);
        p.setHorasTotais(novasHoras);
    }

    /** Remover programa */
    public void eliminarProgramaV(ProgramaEstudante p) {
        programas.remove(p);
        p.setParceiro(null);
    }

    /** Aprovar candidatura de um estudante */
    public void aprovarCandidatura(Candidatura c) {
        c.setEstado(null);
    }

    /** Rejeitar candidatura de um estudante */
    public void rejeitarCandidatura(Candidatura c) {
        c.setEstado(null);
    }
}//fim classe