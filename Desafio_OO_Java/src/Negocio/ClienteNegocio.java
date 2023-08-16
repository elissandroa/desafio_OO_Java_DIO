package Negocio;

import java.util.Optional;

import basedados.Banco;
import entidades.Cliente;
import utilidade.LeitoraDados;



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
	
	
	public void CadastrarNovoCliente() {
		System.out.printf("Digite o Cpf: ");
		String cpf = LeitoraDados.lerDado();
    	System.out.printf("Digite o nome: ");
    	String nome = LeitoraDados.lerDado();
    	if (bancoDados.getClientes().isEmpty()){
    		bancoDados.adicionarCliente(new Cliente(nome, cpf));
    	} else if(!bancoDados.getClientes().isEmpty() && verificaCpf(cpf)){
    		System.out.println("Cliente já cadastrado!");
    	} else {
    		bancoDados.adicionarCliente(new Cliente(nome, cpf));
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


	public Optional<Cliente> consultar(String cpf) {
		for (Cliente cliente:bancoDados.getClientes()) {
			if(cliente.getCpf().equals(cpf)) {
				return Optional.of(cliente);
			}
		}
		return Optional.empty();
	}


	public void listarClientes() {
		if (bancoDados.getClientes().isEmpty()) {
			System.out.println("Não há clientes cadastrados!");
		} else {
			for (Cliente cliente:bancoDados.getClientes()) {
				System.out.println(cliente);
			}
	
		}
		}
	
}
	
