package lp.Equipa11_comp2.DTO;
/**
 * @author beatriz silva
 */
//DTO = Data Transfer Object
//Esta classe serve apenas para transportar dados entre o backend e o frontend
public class UtilizadorDTO {
	private Long id;
	private String nome;
	private int idade;
	private String email;

 // Getters e setters normais
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public int getIdade() { return idade; }
	public void setIdade(int idade) { this.idade = idade; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
 
}//fim class
