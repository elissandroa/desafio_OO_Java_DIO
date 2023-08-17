package basedados;

import java.util.ArrayList;
import java.util.List;

import entidades.Caderno;
import entidades.Cliente;
import entidades.Cupom;
import entidades.Livro;
import entidades.Pedido;
import entidades.Produto;


public class Banco {
	private List<Caderno> cadernos = new ArrayList<Caderno>();
	private List<Livro> livros = new ArrayList<Livro>();
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	private List<Cupom> cupons;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public Banco() {
	}

		
	public Banco(List<Caderno> cadernos, List<Livro> livros, List<Pedido> pedidos, List<Cupom> cupons,
			List<Cliente> clientes, List<Produto> produtos) {
		this.cadernos = cadernos;
		this.livros = livros;
		this.pedidos = pedidos;
		this.cupons = new ArrayList<>();
		cupons.add(new Cupom("CUPOM2",2));
		cupons.add(new Cupom("CUPOM5", 5));
		cupons.add(new Cupom("CUPOM7", 7));
		this.clientes = clientes;
		this.produtos = produtos;
	}


	public List<Caderno> getCadernos() {
		return cadernos;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public List<Cupom> getCupons() {
		return cupons;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}
		
	public List<Produto> getProdutos() {
		return produtos;
	}


	public void adicionarLivro(Livro livro) {
		livros.add(livro);
	}
	
	public void removerLivro(int posicao) {
		livros.remove(posicao);
	}
	
	public void adicionarProduto(Produto produto) {
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
	
	public void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public void removerCliente(int posicao) {
		clientes.remove(posicao);
	}


	public void adicionarCaderno(Caderno caderno) {
		cadernos.add(caderno);
		
	}
	
	public void removerCaderno(int posicao) {
		cadernos.remove(posicao);
	}

}
