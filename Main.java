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
                                           "Listar Contas", "Excluir Conta", "Excluir Cliente"));
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
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
        System.out.println("### Crie e vincule a conta ao cliente: ");

        int agencia, saldo, numero;
        System.out.println("### Informe o numero da agencia: ");
        agencia = sc.nextInt();
        sc.nextLine();
        System.out.println("### Informe o saldo inicial da conta: ");
        saldo = sc.nextInt();
        sc.nextLine();
        

        Conta newConta = factory.createConta(agencia, saldo);
        selectedClient.addConta(newConta);
        System.out.println("\n### Conta criada com sucesso");

        break;

      case 8:

        break;
      case 9:

        System.out.println("\n### Informe o índice do cliente:");
        System.out.println(clientesToString(listaClientes));

        if (listaClientes.isEmpty()) {
            System.out.println("### Nenhum cliente cadastrado!");
            break;
        }

        int clienteIndex = sc.nextInt();
        sc.nextLine();

        if (clienteIndex < 0 || clienteIndex >= listaClientes.size()) {
            System.out.println("### Índice de cliente inválido!");
            break;
        }

        Cliente clienteSelecionado = listaClientes.get(clienteIndex);
        ArrayList<Conta> contasCliente = clienteSelecionado.getContas();

        if (contasCliente.isEmpty()) {
            System.out.println("### Este cliente não possui contas para excluir!");
            break;
        }

        System.out.println("\n### Contas do cliente:");
        System.out.println(clienteSelecionado.contasToString());
        System.out.println("Informe o índice da conta que deseja excluir:");

        int contaIndex = sc.nextInt();
        sc.nextLine();

        if (contaIndex < 0 || contaIndex >= contasCliente.size()) {
            System.out.println("### Índice de conta inválido!");
            break;
        }

        Conta contaRemovida = clienteSelecionado.removeConta(contaIndex);
        System.out.println("### Conta " + contaRemovida.getNumero() + " removida com sucesso!");

        break;

      case 10:
        if (listaClientes.isEmpty()) {
            System.out.println("### Nenhum cliente cadastrado!");
            break;
        }

        System.out.println("\n### Clientes cadastrados:");
        System.out.println(clientesToString(listaClientes));
        System.out.print("Informe o índice do cliente que deseja excluir: ");
        int indiceCliente = sc.nextInt();
        sc.nextLine();

        if (indiceCliente < 0 || indiceCliente >= listaClientes.size()) {
            System.out.println("### Índice inválido!");
            break;
        }

        Cliente clienteExcluir = listaClientes.get(indiceCliente);
        System.out.println("### Confirma exclusão do cliente " + clienteExcluir.getNome() + "? (s/n)");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("s")) {
            Factory.removerCliente(listaClientes, indiceCliente);
            System.out.println("### Cliente removido com sucesso!");
        } else {
            System.out.println("### Operação cancelada.");
        }

        break;
      
      default:
        System.out.println("\n### Opcao invalida!");
        break;
      }
    }
    System.out.println("\n### Fim");
  }
}
