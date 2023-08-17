package Negocio;



import java.util.Optional;
import java.util.Scanner;

import basedados.Banco;
import entidades.Caderno;
import entidades.Genero;
import entidades.Livro;
import entidades.Produto;
import utilidade.LeitoraDados;

public class ProdutoNegocio {
	public static Scanner sc = new Scanner(System.in);
	
	private Banco bancoDados;

	public ProdutoNegocio() {
	}

	public ProdutoNegocio(Banco bancoDados) {
		this.bancoDados = bancoDados;
	}

	public Banco getBancoDados() {
		return bancoDados;
	}

	public void setBancoDados(Banco bancoDados) {
		this.bancoDados = bancoDados;
	}

	public void salvar(Livro livro) {
		System.out.println("**************************************************************");
		System.out.printf("Digite o Nome do Livro: ");
		String nome = LeitoraDados.lerDado();
		System.out.printf("Digite o Valor do livro: ");
		Double valor = sc.nextDouble();
		System.out.printf("Digite a quantidade: ");
		int quantidade = sc.nextInt();
		String codigo = "PR%04d";
		codigo = String.format(codigo, bancoDados.getProdutos().size());
		System.out.println("Digite o valor:");
		Livro prod = new Livro(codigo, valor, quantidade, nome, Genero.SUSPENSE);
		bancoDados.adicionarLivro(prod);
		bancoDados.adicionarProduto(prod);
		}
	
	

	
	public void listarTodos() {
		// TODO Auto-generated method stub
		
	}

	
	public void salvarCaderno() {
		System.out.println("**************************************************************");
		System.out.printf("Digite a quantidade de matérias: ");
		int quantidade = sc.nextInt();
		String codigo = "PR%04d";
		codigo = String.format(codigo, bancoDados.getProdutos().size());
		System.out.println("Digite o valor:");
		double valor = sc.nextDouble();
		Caderno prod = new Caderno(codigo, valor, quantidade, quantidade);
		bancoDados.adicionarCaderno(prod);
		bancoDados.adicionarProduto(prod);
	
	}
	
	public void excluirCaderno(String codigo) {
		int posicao = 0;
		for(Caderno caderno: bancoDados.getCadernos()) {
			if (caderno.getCodigo().equals(codigo)){
				bancoDados.removerCaderno(posicao);
				excluirProduto(codigo);
				System.out.println("Caderno excluido !");
				break;
			}
			posicao += 1;
		}
	}
	
	public void excluirLivro(String codigo) {
		int posicao = 0;
		for(Livro livro: bancoDados.getLivros()) {
			if (livro.getCodigo().equals(codigo)){
				bancoDados.removerLivro(posicao);
				excluirProduto(codigo);
				System.out.println("Livro excluido !");
				break;
			}
			posicao += 1;
		}
	}
	

	public void excluirProduto(String codigo) {
		int posicao = 0;
		for(Produto produto: bancoDados.getProdutos()) {
			if(produto.getCodigo().equals(codigo)) {
				bancoDados.removerProduto(posicao);
				break;
			}
			posicao += 1;
		}
	}
	
	public Optional<Caderno> consultarCaderno() {
		System.out.printf("Digite o código do caderno: ");
		String codigoCaderno = LeitoraDados.lerDado();
		for (Caderno caderno: bancoDados.getCadernos()) {
			if (caderno.getCodigo().equals(codigoCaderno)) {
				System.out.println(caderno);
				return Optional.of(caderno);
			}
		}
		return Optional.empty();
	}
	
	public Optional<Livro> consultarLivro() {
		System.out.printf("Digite o código do livro: ");
		String codigoLivro = LeitoraDados.lerDado();
		for (Livro livro: bancoDados.getLivros()) {
			if (livro.getCodigo().equals(codigoLivro)) {
				System.out.println(livro);
				return Optional.of(livro);
			}
		}
		return Optional.empty();
	}
	
	public void listarProdutos() {
		for(Livro livro: bancoDados.getLivros()) {
			System.out.println(livro);
		}
		for(Caderno caderno: bancoDados.getCadernos()) {
				System.out.println(caderno);
		}
		
	}
}
