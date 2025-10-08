import java.util.ArrayList;

public class Factory {

  public Cliente createCliente(String nome, String cpf) {
    return new Cliente(nome, cpf);
  }
  public Conta createConta(int agencia, double saldo) {
    final int NUMERO = (int) (Math.random() * 1000000);
    return new Conta(agencia, saldo, NUMERO);
  }

  public static void removerCliente(ArrayList<Cliente> listaClientes, int index) {
    if (index >= 0 && index < listaClientes.size()) {
        listaClientes.remove(index);
  }
}

}
