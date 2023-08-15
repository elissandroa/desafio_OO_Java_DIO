package basedados;

import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;
import entidades.Cupom;
import entidades.Pedido;
import entidades.Produto;

public class Banco {
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	private List<Cupom> cupons = new ArrayList<>();
	private Cliente cliente;

	public Banco() {
	}

	public Banco(List<Produto> produtos, List<Pedido> pedidos, Cliente cliente) {
		this.produtos = produtos;
		this.pedidos = pedidos;
		this.cliente = cliente;
		cupons.add(new Cupom("CUPOM2",2));
		cupons.add(new Cupom("CUPOM5",5));
		cupons.add(new Cupom("CUPOM7",7));
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public List<Cupom> getCupons() {
		return cupons;
	}
	
		
	public void adicionaProduto(Produto produto) {
		produtos.add(produto);
	}
	
	public void removerProduto(int posicao) {
		produtos.remove(posicao);
	}
	
	public void adicionarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	public void removerPedido(int posicao) {
		pedidos.remove(posicao);
	}
	
}
