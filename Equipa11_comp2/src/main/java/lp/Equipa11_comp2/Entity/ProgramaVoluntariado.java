package lp.Equipa11_comp2.Entity;

/**
 * @author miguel silva
 */

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "programa_voluntariado")
public class ProgramaVoluntariado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private int horas_servico;
    private String local;
    private int vagas;
    private int vagasOcupadas;

    @ManyToOne
    @JoinColumn(name = "id_parceiro")
    private Parceiro parceiro;

    @OneToMany(mappedBy = "programaVoluntariado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Candidatura> candidaturas = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;

    public ProgramaVoluntariado() {}

    public ProgramaVoluntariado(String titulo, String descricao, int horas_servico, String local, int vagas) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.horas_servico = horas_servico;
        this.local = local;
        this.vagas = vagas;
        this.vagasOcupadas = 0;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long idPrograma) {} 
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public int getHorasServico() { return horas_servico; }
    public void setHorasServico(int horasServico) { this.horas_servico = horas_servico; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public int getVagas() { return vagas; }
    public void setVagas(int vagas) { this.vagas = vagas; }

    public int getVagasOcupadas() { return vagasOcupadas; }
    public void setVagasOcupadas(int vagasOcupadas) { this.vagasOcupadas = vagasOcupadas; }

    public Parceiro getParceiro() { return parceiro; }
    public void setParceiro(Parceiro parceiro) { this.parceiro = parceiro; }
    
    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }

    public List<Candidatura> getCandidaturas() { return candidaturas; }
    public void setCandidaturas(List<Candidatura> candidaturas) { this.candidaturas = candidaturas; }

	
}
