import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  private static final Factory factory = new Factory();
  private static final Scanner sc = new Scanner(System.in);
  private static Cliente cadastrarCliente() {
    String nome, cpf;
    System.out.println("Informe nome: ");
    nome = sc.nextLine();
    System.out.println("Informe cpf: ");
    cpf = sc.nextLine();
    return factory.createCliente(nome, cpf);
  }

  private static String clientesToString(ArrayList<Cliente> clientes) {
    String clientesString = "";
    for (int i = 0; i < clientes.size(); i++) {
      clientesString += i + " - " + clientes.get(i).toString() + "\n";
    }
    return clientesString;
  }
  public static void main(String[] args) {
    Menu mainMenu = new Menu("Menu Principal",
                             Arrays.asList("Sair", "Conta", "Cliente",
                                           "Operacoes", "Cadastrar Cliente",
                                           "Listar Clientes", "Criar Conta",
                                           "Listar Contas", "Excluir Conta"));
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    int op = 4;
    while (op != 0) {
      op = mainMenu.getSelection();
      switch (op) {
      case 0:
        break;
      case 1:
        // Sair
        op = 0;
        break;
      case 2:
        // Conta
        break;
      case 3:
        // Cliente
        break;
      case 4:
        // Operacoes

        break;
      case 5:
        Cliente cliente = cadastrarCliente();
        listaClientes.add(cliente);
        System.out.println("\n### Cliente adicionado com sucesso");
        break;
      case 6:
        System.out.println(clientesToString(listaClientes));

        break;
      case 7:
        // Criar conta
        System.out.println("\n### Informe o index do cliente");
        System.out.println(clientesToString(listaClientes));
        Cliente selectedClient = listaClientes.get(sc.nextInt());
        if (selectedClient == null) {
          System.out.println("\n### Opcao invalida!");
          break;
        }

        System.out.println("### Cliente selecionado : " +
                           selectedClient.getNome());
        System.out.println("### Crie e vincule a conta ao cliente: ");

        int agencia, saldo, numero;
        System.out.println("### Informe o numero da agencia: ");
        agencia = sc.nextInt();
        System.out.println("### Informe o saldo inicial da conta: ");
        saldo = sc.nextInt();
        System.out.println("### Informe o numero da conta: ");
        numero = sc.nextInt();

        Conta newConta = factory.createConta(agencia, saldo, numero);
        selectedClient.addConta(newConta);
        System.out.println("\n### Conta criada com sucesso");
        // processo de criacao de conta

        break;
      case 8:
        // listar contas
        break;
      case 9:
        // Excluir uma conta

        break;
      default:
        System.out.println("\n### Opcao invalida!");
        break;
      }
    }
    System.out.println("\n### Fim");
  }
}

// Cada cliente vai ter um array de contas,
// Ele mesmo vai administrar essas contas

// Quando for escolhido criar conta, vai ser listado todos os clientes, de modo
// que se possa escolher dessa lista de clientes qual vai ser o dono da conta
// pelo index da lista dele