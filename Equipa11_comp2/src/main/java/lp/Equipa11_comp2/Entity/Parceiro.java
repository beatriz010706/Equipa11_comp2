package lp.Equipa11_comp2.Entity;
/**
 * @author beatriz silva 
 */

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parceiro")
@PrimaryKeyJoinColumn(name = "id_parceiro")
public class Parceiro extends Utilizador {

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;

    private String local;

    @OneToMany(mappedBy = "parceiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramaVoluntariado> programas = new ArrayList<>();

    // -----------------------------
    // CONSTRUTORES
    // -----------------------------
    public Parceiro() {}

    public Parceiro(String nome, int idade, String email, String password,
                    Tipo tipo, String local) {
        super(nome, idade, email, password);
        this.tipo = tipo;
        this.local = local;
    }

    // -----------------------------
    // GETTERS E SETTERS
    // -----------------------------
    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public List<ProgramaVoluntariado> getProgramas() { return programas; }
    public void setProgramas(List<ProgramaVoluntariado> programas) { this.programas = programas; }

}//fim classe
