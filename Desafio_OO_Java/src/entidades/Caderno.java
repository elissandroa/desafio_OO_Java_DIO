package entidades;

public class Caderno extends Produto{
	private Materiais tipo;

	public Caderno() {
	}

	public Caderno(Materiais tipo) {
		this.tipo = tipo;
	}

	public Materiais getTipo() {
		return tipo;
	}

	public void setTipo(Materiais tipo) {
		this.tipo = tipo;
	}
	
}
