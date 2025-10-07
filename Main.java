import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static final Factory factory = new Factory();
	private static final Scanner sc = new Scanner(System.in);
	private static Cliente cadastrarCliente(){
		String nome, cpf;
		System.out.println("Informe nome: ");
		nome = sc.nextLine();
		System.out.println("Informe cpf: ");
		cpf = sc.nextLine();
		return factory.createCliente(nome, cpf);
	}
	public static void main(String[] args) {
		Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Sair","Conta", "Cliente", "Operacoes", "Cadastrar Cliente", "Listar Clientes"));
		List<Cliente> listaClientes = new ArrayList<>();
		int op = 4;
		while(op!=0){
			op = mainMenu.getSelection();
			switch (op) {
				case 0:
					break;
				case 1:
					//implementar logica
					break;
				case 2:
					//implementar logica
					break;
				case 3:
					//implementar logica
					break;
				case 4:
					Cliente cliente = cadastrarCliente();
					listaClientes.add(cliente);
					break;
				case 5:
					for (Cliente c: listaClientes) {
						System.out.println(c);
					}
					break;
				default:
					System.out.println("Opcao invalida!");
					break;
			}
		}
		System.out.println("Fim");
	}

}