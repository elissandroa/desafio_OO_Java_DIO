package entidades;

public class Livro extends Produto {
	private String nome;
	private Genero genero;
	
	public Livro() {
	}

	
	public Livro(String codigo, double preco, int quantidade, String nome, Genero genero) {
		super(codigo, preco, quantidade);
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

	@Override
	public double calcularFrete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Livro [Codigo = "+ codigo + " Nome= " + nome + ", Genero= " + genero + "]";
	}

}
