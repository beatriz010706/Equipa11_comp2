package lp.Equipa11_comp2.Entity;
/**
 * @author beatriz silva
 */

import jakarta.persistence.*; 
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "utilizador")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilizador {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilizador;

    private String nome;

    private int idade;

    @Email
    @Column(unique = true)
    private String email;

    @Size(min = 8)
    private String password;

    public Utilizador() {}

    public Utilizador(String nome, int idade, String email, String password) {
        this.nome = nome; this.idade = idade; this.email = email; this.password = password;
    }

    public Long getIdUtilizador() { return idUtilizador; }
    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void setNome(String nome) { this.nome = nome; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}//fim da classe
