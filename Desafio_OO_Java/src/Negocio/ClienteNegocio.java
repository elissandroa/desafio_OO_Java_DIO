package Negocio;

import java.util.Optional;

import basedados.Banco;
import entidades.Cliente;


public class ClienteNegocio {

	private Banco bancoDados;
	
	
	public ClienteNegocio() {
	}


	public ClienteNegocio(Banco bancoDados) {
		this.bancoDados = bancoDados;
	}


	public Banco getBancoDados() {
		return bancoDados;
	}
	
	public Boolean verificaCpf(String cpf) {
		for (Cliente cliente: bancoDados.getClientes()) {
			if(cliente.getCpf().equals(cpf)) {
				return true;
			}
		}
		return false;
	}
	
	public Optional<Cliente> consultar(String cpf){
		for (Cliente cliente: bancoDados.getClientes()) {
			if(cliente.getCpf().equals(cpf)) {
				return Optional.of(cliente);
			}
		}
		return Optional.empty();
	}
	
	public void CadastrarNovoCliente(Cliente cliente) {
		if (verificaCpf(cliente.getCpf())) {
			System.out.println("Cpf já cadastrado!");
		} else {
			bancoDados.adicionarCliente(cliente);
		}
	}
	
	public void excluirCliente(String cpf) {
		int posicao = -1;
		for (Cliente cliente: bancoDados.getClientes()) {
			posicao += 1;
			if(cliente.getCpf().equals(cpf)) {
				bancoDados.removerCliente(posicao);
			}
		}
	}
	
}
	
