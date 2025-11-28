package lp.Equipa11_comp2.Entity;
/**
 * @author diogo garcia
 */
import jakarta.persistence.*;

@Entity
@Table(name = "tipo")
public class Tipo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipo;
    private String descricao;
    public Tipo() {}
    public Tipo(String descricao) { this.descricao = descricao; }
    public Long getIdTipo() { return idTipo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
