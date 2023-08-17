package console;

import java.util.Optional;

import Negocio.ClienteNegocio;
import Negocio.PedidoNegocio;
import Negocio.ProdutoNegocio;
import basedados.Banco;
import entidades.Cliente;
import entidades.Livro;
import utilidade.LeitoraDados;

public class Start {
	private static Cliente clienteLogado = null;

    private static Banco banco = new Banco();

    private static ClienteNegocio clienteNegocio = new ClienteNegocio(banco);
    private static PedidoNegocio pedidoNegocio = new PedidoNegocio(banco);
    private static ProdutoNegocio produtoNegocio = new ProdutoNegocio(banco);

    /**
     * Método utilitário para inicializar a aplicação.
     * @param args Parâmetros que podem ser passados para auxiliar na execução.
     */
    public static void main(String[] args) {
    	
    	

    	
        System.out.println("Bem vindo ao e-Compras");

        String opcao = "";
        boolean opcao_cliente = true;
        
        

        	
 
        while(opcao_cliente) {
        	System.out.println("**************************************************************");
        	System.out.println("Menu Inicial");
            System.out.println("1 - listar clientes");
            System.out.println("2 - Adicionar clientes");
            System.out.println("3 - Consultar cliente:");
            System.out.println("4 - Abrir módulo de pedidos");
            System.out.println("**************************************************************");
            opcao = LeitoraDados.lerDado();
        	
            switch (opcao) {
        	case "1":
        		clienteNegocio.listarClientes();
        		break;
        	case "2":
        		clienteNegocio.CadastrarNovoCliente();
        		break;
        	case "3":
        		clienteNegocio.consultarCliente();
        		break;
        	case "4":
        		opcao = "";
        		opcao_cliente = false;
        		break;
        	default:
        		System.out.println("Opção inválida");
        	}
        }
        
       
        while(true) {

            if (clienteLogado == null) {

                System.out.printf("Digite o cpf:");

                String cpf = "";
                cpf = LeitoraDados.lerDado();

                identificarUsuario(cpf);
            }
            
                 
            System.out.println("**************************************************************");
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Excluir Livro");
            System.out.println("3 - Consultar livro");
            System.out.println("4 - Cadastrar Caderno");
            System.out.println("5 - Excluir Caderno");
            System.out.println("6 - Consultar Caderno");
            System.out.println("7 - Fazer pedido");
            System.out.println("8 - Excluir pedido");
            System.out.println("9 - Consultar pedido");
            System.out.println("10 - Listar produtos");
            System.out.println("11 - Listar pedidos");
            System.out.println("12 - Deslogar");
            System.out.println("13 - Sair");
            System.out.println("**************************************************************");
            opcao = LeitoraDados.lerDado();

            switch (opcao) {
                case "1":
                    Livro livro = LeitoraDados.lerLivro();
                    produtoNegocio.salvar(livro);
                    break;
                case "2":
                    System.out.printf("Digite o código do livro: ");
                    String codigoLivro = LeitoraDados.lerDado();
                    produtoNegocio.excluirLivro(codigoLivro);
                    break;
                case "3":
                    System.out.println("Consultar Livro");
                    produtoNegocio.consultarLivro();
                    break;
                case "4":
                    produtoNegocio.salvarCaderno();
                    break;
                case "5":
                	System.out.printf("Digite o código do caderno: ");
                	String codigoCaderno = LeitoraDados.lerDado();
                	produtoNegocio.excluirCaderno(codigoCaderno);
                	break;
                case "6":
                	System.out.println("Consultar Caderno");
                	produtoNegocio.consultarCaderno();
                	break;
                case "7":
                    pedidoNegocio.adicionarNovoPedido();
                    break;
                case "8":
                    System.out.printf("Digite o código do pedido: ");
                    String codigoPedido = LeitoraDados.lerDado();
                    pedidoNegocio.excluirPedido(codigoPedido);
                    break;
                case "9":
                	pedidoNegocio.consultarPedido();
                	break;
                case "10":
                    produtoNegocio.listarProdutos();
                    break;
                case "11":
                    pedidoNegocio.listarPedidos();
                    break;
                case "12":
                    System.out.println(String.format("Volte sempre %s!", clienteLogado.getNome()));
                    clienteLogado = null;
                    main(args);
                    break;
                case "13":
                    System.out.println("Aplicação encerrada.");
                    System.exit(0);
                    break;	
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    public static Cliente getClienteLogado() {
		return clienteLogado;
	}

	/**
     * Procura o usuário na base de dados.
     * @param cpf CPF do usuário que deseja logar na aplicação
     */
    private static void identificarUsuario(String cpf) {

        Optional<Cliente> resultado = clienteNegocio.consultar(cpf);

        if (resultado.isPresent()) {

            Cliente cliente = resultado.get();
            System.out.println(String.format("Olá %s! Você está logado.", cliente.getNome()));
            clienteLogado = cliente;
        } else {
            System.out.println("Usuário não cadastrado.");
            System.out.println("Deseja Cadastrar um Cliente ?: (s/n):");
            String option = LeitoraDados.lerDado();
            if (option.equals("s") || option.equals("S")) {
            	clienteNegocio.CadastrarNovoCliente();
            	Start.main(null);
            }
            else {
            	System.out.println("Acesso negado, programa fechado...");
            	System.exit(0);
            }
        }
    }
}
