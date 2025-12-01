package lp.Equipa11_comp2.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parceiro")
@PrimaryKeyJoinColumn(name = "id_parceiro")
public class Parceiro extends Utilizador {

    private String local;

    // 1 Parceiro -> vários ProgramasVoluntariado
    @OneToMany(mappedBy = "parceiro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramaVoluntariado> programasVoluntariado = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;

    public Parceiro() {}

    public Parceiro(String nome, String email, String password, String local) {
        super(nome, email, password);
        this.local = local;
    }

    // Getters e Setters
    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }
    
    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    public List<ProgramaVoluntariado> getProgramasVoluntariado() { return programasVoluntariado; }
    public void setProgramasVoluntariado(List<ProgramaVoluntariado> programasVoluntariado) { this.programasVoluntariado = programasVoluntariado; }

    // -----------------------------
    // MÉTODOS DO PARCEIRO
    // -----------------------------

    public void registarPrograma(ProgramaVoluntariado p) {
        programasVoluntariado.add(p);
        p.setParceiro(this);
    }

    public void editarPrograma(ProgramaVoluntariado p, String novoTitulo, int novasHoras) {
        p.setTitulo(novoTitulo);
        p.setHorasServico(novasHoras);
    }

    public void eliminarPrograma(ProgramaVoluntariado p) {
        programasVoluntariado.remove(p);
        p.setParceiro(null);
    }
}

