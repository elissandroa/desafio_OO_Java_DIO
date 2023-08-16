package entidades;

public abstract class Produto {
	private int id;
	private double preco;
	private int quantidade;
	
	public Produto() {
	}

	public Produto(int id, double preco, int quantidade) {
		this.id = id;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public abstract double calcularFrete();
	
}
