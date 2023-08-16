package Negocio;

import basedados.Banco;
import entidades.Cupom;
import entidades.Pedido;
import entidades.Produto;

public class PedidoNegocio {
	
private Banco bancoDados;
public Produto novoProduto;
	
	
	public PedidoNegocio() {
	}


	public PedidoNegocio(Banco banco) {
		this.bancoDados = banco;
	}


	public Banco getBancoDados() {
		return bancoDados;
	}
	
	public void listarPedidos () {
		for (Pedido pedido: bancoDados.getPedidos()) {
			System.out.println(pedido);
		}
	}
	
	public void adicionarNovoPedido() {
		String codigo = "PR%04d";
		codigo = String.format(codigo, bancoDados.getProdutos().size());
		novoProduto.setCodigo(codigo);
		novoProduto.setPreco(0);
	}
	
	
	
	public void salvar(Pedido novoPedido) {
		bancoDados.adicionarPedido(novoPedido);
	}


	public void salvar(Pedido pedido, Cupom cupom) {
		// TODO Auto-generated method stub
		
	}


	public void excluir(String codigoPedido) {
		// TODO Auto-generated method stub
		
	}
}
