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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilizador;

    private String nome;

    @Email
    @Column(unique = true)
    private String email;

    @Size(min = 8)
    private String password;

    public Utilizador() {}

    public Utilizador(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    public Long getIdUtilizador() { return idUtilizador; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
