package Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import basedados.Banco;
import console.Start;
import entidades.Cliente;
import entidades.Pedido;
import entidades.Produto;
import utilidade.LeitoraDados;

public class PedidoNegocio {
private static Scanner sc = new Scanner(System.in);
private Banco bancoDados;
public Produto novoProduto;
	public List<Produto> prod ;
	public Cliente cliente;
	
	Pedido pedido;
	
	public PedidoNegocio() {
	}


	public PedidoNegocio(Banco banco) {
		this.bancoDados = banco;
	}


	public Banco getBancoDados() {
		return bancoDados;
	}

	
	
	public void adicionarNovoPedido() {
		Double total = 0.0;	
		System.out.println("Digite o código dos produtos para inserir no pedido");
		boolean verifica = true;
	
		prod = new ArrayList<Produto>();
		while(verifica) {
			
			System.out.printf("Codigo: ");
			String codigoProduto = LeitoraDados.lerDado();
			System.out.println("Quantidade: ");
			int quantidade = sc.nextInt();
		
			for (Produto produto: bancoDados.getProdutos()) {
				if (produto.getCodigo().equals(codigoProduto)) {
					prod.add(produto);
					total += (quantidade * produto.getPreco());
				}
				
			}
			
			System.out.println("Adiciona outro produto (s/n)");
			String opcao = LeitoraDados.lerDado();
			if(opcao.equals("s") || opcao.equals("S")) {
				verifica = true;
			} else {
				verifica = false;
			}
			
					
		}
		System.out.printf("Deseja usar um Cupom - CUPOM (s/n ?: ");
		String opcaoCupom = LeitoraDados.lerDado();
		if(opcaoCupom.equals("s") || opcaoCupom.equals("S")) {
			System.out.println("Use os códigos CUPOM2, CUPOM5 ou CUPOM7");
			System.out.printf("Digite o código: ");
			String cupom = LeitoraDados.lerDado();
				if(cupom.equals("CUPOM2")) {
					total *= 1.0 - (2.0/100.0);
				} else if (cupom.equals("CUPOM5")) {
					total *= 1.0 - (5.0/100.0);
				} else {
					total *= 1.0 - (7.0/100.0);
			}
		}
		
				
		String codigo = "PE%05d";
		codigo = String.format(codigo, bancoDados.getPedidos().size());
		Pedido pedido = new Pedido(codigo,Start.getClienteLogado(),prod,total);
		bancoDados.adicionarPedido(pedido);
		
	}
	
	
	public void listarPedidos() {
		int count = 0;
		if(bancoDados.getPedidos().isEmpty()) {
			System.out.println("Não há pedidos cadastrados");
		} else {
			for (Pedido pedido: bancoDados.getPedidos()) {
				if (pedido.getCliente().equals(Start.getClienteLogado())) {
					System.out.println("Código: "+pedido.getCodigo()+" Cliente:"+pedido.getCliente().getNome()+" Valor: "+pedido.getTotal());
					count += 1;
				}
			}
		}
		if(count == 0) {
			System.out.println("Não há pedidos cadastrados para esse cliente");
		}
	}
	
	

	public Optional<Pedido> excluirPedido(String codigoPedido) {
		int posicao = 0;
		for(Pedido pedido: bancoDados.getPedidos()) {
			if(pedido.getCodigo().equals(codigoPedido)) {
				bancoDados.removerPedido(posicao);
				System.out.println("Pedido removido com sucesso !");
				break;
			}
			posicao += 1;
		}
		return Optional.empty();
	}


	public Optional<Pedido> consultarPedido() {
		System.out.printf("Digite o código do pedido: ");
		String codigoPedido = LeitoraDados.lerDado();
		for (Pedido pedido: bancoDados.getPedidos()) {
			if(Start.getClienteLogado().equals(pedido.getCliente())) {
				if(pedido.getCodigo().equals(codigoPedido)) {
					System.out.println("Codigo: "+ pedido.getCodigo() + " Itens: " + pedido.getProdutos()+ " Total: " + pedido.getTotal());
				}
			} else {
				System.out.println("Não há cadastrados para este cliente");
			}
			
		}
		return Optional.empty();
	}
}
