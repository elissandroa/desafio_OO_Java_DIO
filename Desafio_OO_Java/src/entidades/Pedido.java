package entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {
	private String codigo;
	private Cliente cliente;
	private List<Produto> produtos = new ArrayList<Produto>();
	private double total;
	
	public Pedido() {
	}

	public Pedido(String codigo, Cliente cliente, List<Produto> produtos, double total) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.produtos = produtos;
		this.total = total;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
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

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", cliente=" + cliente + ", produtos=" + produtos + ", total=" + total
				+ "]";
	}
	
}
