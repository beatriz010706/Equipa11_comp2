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
    @JoinColumn(name = "idTipo")
    private Tipo tipo;

    private String local;

    public Parceiro() {}

    public Parceiro(String nome, int idade, String email, String password, Tipo tipo, String local) {
        super(nome, idade, email, password);
        this.tipo = tipo;
        this.local = local;
    }

    public Tipo getTipo() { return tipo; }
    public String getLocal() { return local; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }
    public void setLocal(String local) { this.local = local; }
}
