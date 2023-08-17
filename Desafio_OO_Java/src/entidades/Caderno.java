package entidades;

public class Caderno extends Produto{
	private int tipo;

	public Caderno() {
	}
	

	public Caderno(String codigo, double preco, int quantidade, int tipo) {
		super(codigo, preco, quantidade);
		this.tipo = tipo;
	}


	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public double calcularFrete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Caderno [ Código= " +codigo+" "+" tipo= " + tipo + " matérias ]";
	}
	
}
