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
    ArrayList<Cliente> listaClientes = new ArrayList<>();
    int op = 4;
    while (op != 0) {
      op = mainMenu.getSelection(sc);
      switch (op) {
      case 0:
        break;
      case 1:

        op = 0;
        break;
      case 2:

        break;
      case 3:

        break;
      case 4:

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

        System.out.println("\n### Informe o index do cliente");
        System.out.println(clientesToString(listaClientes));
        Cliente selectedClient = listaClientes.get(sc.nextInt());
        sc.nextLine();
        if (selectedClient == null) {
          System.out.println("\n### Opcao invalida!");
          break;
        }

        System.out.println("### Cliente selecionado : " +
                           selectedClient.getNome());

        int agencia;
        double saldo;
        System.out.println("### Informe o numero da agencia: ");
        agencia = sc.nextInt();
        sc.nextLine();
        System.out.println("### Informe o saldo inicial da conta: ");
        saldo = sc.nextDouble();
        sc.nextLine();
        Conta newConta = factory.createConta(agencia, saldo);
        selectedClient.addConta(newConta);
        System.out.println("\n### Conta criada com sucesso");
        System.out.println("### Dados da conta: " + newConta.toString());

        break;
      case 8:

        break;
      case 9:

        break;
      default:
        System.out.println("\n### Opcao invalida!");
        break;
      }
    }
    System.out.println("\n### Fim");
  }
}
