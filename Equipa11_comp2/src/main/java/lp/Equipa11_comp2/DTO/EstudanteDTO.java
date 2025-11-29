package lp.Equipa11_comp2.DTO;
/**
 * @author beatriz silva
 */
public class EstudanteDTO {
	private Long id;
    private String nome;
    private int idade;
    private String email;
    private int numeroEstudante;
    private String curso;
    private Long idPrograma; // ID do ProgramaEstudante
    private String tipo = "Estudante"; // sempre Estudante

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public int getIdade() {return idade;}
	public void setIdade(int idade) {this.idade = idade;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public int getNumeroEstudante() {return numeroEstudante;}
	public void setNumeroEstudante(int numeroEstudante) {this.numeroEstudante = numeroEstudante;}
	
	public String getCurso() {return curso;}
	public void setCurso(String curso) {this.curso = curso;}
	
	public Long getIdPrograma() {return idPrograma;}
	public void setIdPrograma(Long idPrograma) {this.idPrograma = idPrograma;}

	public String getTipo() {return tipo;}
	public void setTipo(String tipo) {this.tipo = tipo;}
    
}//fim classe
