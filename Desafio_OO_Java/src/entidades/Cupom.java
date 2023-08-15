package entidades;

public class Cupom {
	private String codigo;
	private double desconto;
	
	public Cupom() {
	}
	
	public Cupom(String codigo, double desconto) {
		this.codigo = codigo;
		this.desconto = desconto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
}
