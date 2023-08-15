package entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int codigo;
	private Cliente cliente;
	private List<Produto> produtos = new ArrayList<Produto>();
	private double total;
	
	public Pedido() {
	}

	public Pedido(int codigo, Cliente cliente, List<Produto> produtos, double total) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.produtos = produtos;
		this.total = total;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
}
