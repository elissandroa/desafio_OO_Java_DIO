package Negocio;

import java.util.ArrayList;
import java.util.List;

import basedados.Banco;
import entidades.Cliente;
import entidades.Pedido;
import entidades.Produto;
import utilidade.LeitoraDados;

public class PedidoNegocio {
	
private Banco bancoDados;
public Produto novoProduto;
	public List<Produto> prod = new ArrayList<Produto>();
	public Cliente cliente;
	
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
		double total = 0.0;	
		System.out.println("Digite o código dos produtos para inserir no pedido");
		boolean verifica = true;
	
		while(verifica) {
			System.out.println("Codigo: ");
			String codigoProduto = LeitoraDados.lerDado();
			for (Produto produto: bancoDados.getProdutos()) {
				if (produto.getCodigo().equals(codigoProduto)) {
					prod.add(produto);
				}
			}
			
			System.out.println("Adiciona outro produto (s/n)");
			String opcao = LeitoraDados.lerDado();
			if(opcao == "s" || opcao == "S") {
				verifica = true;
			} else {
				verifica = false;
			}
			
			
			
			for (Produto produto: prod) {
				total += (produto.getQuantidade() * produto.getQuantidade());
			}
			
			System.out.println("Deseja usar um Cupom - CUPOM");
			
			
		}
		Pedido pedido = new Pedido(cliente, prod, total);
	}
	
	
	
	public void salvar(Pedido pedido) {
		bancoDados.adicionarPedido(pedido);
	}

	public void excluir(String codigoPedido) {
		// TODO Auto-generated method stub
		
	}
}
