package entidades;

public class Cupom {
	private int codigo;
	private double desconto;
	
	public Cupom() {
	}
	
	public Cupom(int codigo, double desconto) {
		this.codigo = codigo;
		this.desconto = desconto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
}
