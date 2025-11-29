package lp.Equipa11_comp2.DTO;
/**
 * @author beatriz silva
 */
public class ParceiroDTO {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private Long idTipo;
    private String local;
    private String tipoUtilizador = "Parceiro"; // sempre Parceiro

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getIdTipo() { return idTipo; }
    public void setIdTipo(Long idTipo) { this.idTipo = idTipo; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public String getTipoUtilizador() { return tipoUtilizador; }
}//fim classe
