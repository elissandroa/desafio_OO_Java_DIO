package Negocio;

import basedados.Banco;
import entidades.Livro;

public class ProdutoNegocio {
	
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
		// TODO Auto-generated method stub
		
	}

	public void excluir(String codigoLivro) {
		// TODO Auto-generated method stub
		
	}

	public void listarTodos() {
		// TODO Auto-generated method stub
		
	}
	
	
}
