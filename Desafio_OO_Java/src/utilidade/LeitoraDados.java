package utilidade;

import java.util.Optional;
import java.util.Scanner;

import basedados.Banco;
import entidades.Cupom;
import entidades.Livro;
import entidades.Pedido;

public class LeitoraDados {
	
	
	
	private static Scanner sc = new Scanner(System.in);
	
	public static String lerDado() {
		String texto = sc.nextLine(); 
		return texto;
	}

	public static Pedido lerPedido(Banco banco) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Livro lerLivro() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Optional<Cupom> lerCupom(Banco banco) {
		// TODO Auto-generated method stub
		return null;
	}
}
