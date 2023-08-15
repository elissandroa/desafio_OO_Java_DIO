package entidades;

public class Livro extends Produto {
	private String nome;
	private Genero genero;
	
	public Livro() {
	}

	public Livro(String nome, Genero genero) {
		this.nome = nome;
		this.genero = genero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
