package lp.Equipa11_comp2.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipo;

    private String descricaoTipo;

    // 1 Tipo → vários Parceiros
    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Parceiro> tipoParceiros = new ArrayList<>();

    // 1 Tipo → vários ProgramasVoluntariado
    @OneToMany(mappedBy = "tipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramaVoluntariado> tipoPV = new ArrayList<>();

    // -----------------------------
    // Construtores
    // -----------------------------
    public Tipo() {}

    public Tipo(String descricaoTipo) {
        this.descricaoTipo = descricaoTipo;
    }

    // -----------------------------
    // Getters e Setters
    // -----------------------------
    public Long getIdTipo() { return idTipo; }

    public String getDescricaoTipo() { return descricaoTipo; }
    public void setDescricaoTipo(String descricaoTipo) { this.descricaoTipo = descricaoTipo; }

    public List<Parceiro> getTipoParceiros() { return tipoParceiros; }
    public void setTipoParceiros(List<Parceiro> tipoParceiros) { this.tipoParceiros = tipoParceiros; }

    public List<ProgramaVoluntariado> getTipoPV() { return tipoPV; }
    public void setTipoPV(List<ProgramaVoluntariado> tipoPV) { this.tipoPV = tipoPV; }


 // Métodos para gerir listas

 // ----- Parceiros -----
 public void adicionarParceiro(Parceiro p) {
     if (p == null) return;

     // Impede duplicados
     if (!tipoParceiros.contains(p)) {
         tipoParceiros.add(p);
     }

     // Mantém a relação bidirecional consistente
     if (p.getTipo() != this) {
         p.setTipo(this);
     }
 }

 public void removerParceiro(Parceiro p) {
     if (p == null) return;

     if (tipoParceiros.contains(p)) {
         tipoParceiros.remove(p);
     }

     // Apenas remove se estiver associado a este Tipo
     if (p.getTipo() == this) {
         p.setTipo(null);
     }
 }


 // ----- Programas Voluntariado -----
 public void adicionarProgramaVoluntariado(ProgramaVoluntariado p) {
     if (p == null) return;

     if (!tipoPV.contains(p)) {
         tipoPV.add(p);
     }

     if (p.getTipo() != this) {
         p.setTipo(this);
     }
 }

 public void removerProgramaVoluntariado(ProgramaVoluntariado p) {
     if (p == null) return;

     if (tipoPV.contains(p)) {
         tipoPV.remove(p);
     }

     if (p.getTipo() == this) {
         p.setTipo(null);
     }
 }

}
