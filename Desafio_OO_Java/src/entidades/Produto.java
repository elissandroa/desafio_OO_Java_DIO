package entidades;

public abstract class Produto {
	protected String codigo;
	private double preco;
	private int quantidade;
	
	public Produto() {
	}

	public Produto(String codigo, double preco, int quantidade) {
		this.codigo = codigo;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", preco=" + preco + ", quantidade=" + quantidade + "]";
	}

	
}
