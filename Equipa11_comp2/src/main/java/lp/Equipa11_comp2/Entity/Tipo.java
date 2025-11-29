package lp.Equipa11_comp2.Entity;
/**
 * @author diogo garcia
 */
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipo;

    private String descricao;

    // -----------------------------
    // Relações
    // -----------------------------

    // 1 Tipo → vários Parceiros
    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parceiro> parceiros = new ArrayList<>();

    // 1 Tipo → vários ProgramasVoluntariado
    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramaVoluntariado> programasVoluntariado = new ArrayList<>();

    // -----------------------------
    // Construtores
    // -----------------------------
    public Tipo() {}

    public Tipo(String descricao) {
        this.descricao = descricao;
    }

    // -----------------------------
    // Getters e Setters
    // -----------------------------
    public Long getIdTipo() { return idTipo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public List<Parceiro> getParceiros() { return parceiros; }
    public void setParceiros(List<Parceiro> parceiros) { this.parceiros = parceiros; }

    public List<ProgramaVoluntariado> getProgramasVoluntariado() { return programasVoluntariado; }
    public void setProgramasVoluntariado(List<ProgramaVoluntariado> programasVoluntariado) {
        this.programasVoluntariado = programasVoluntariado;
    }
}//fim classe