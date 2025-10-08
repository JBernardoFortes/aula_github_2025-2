public class Factory {
  public Cliente createCliente(String nome, String cpf) {
    return new Cliente(nome, cpf);
  }
  public Conta createConta(int agencia, double saldo) {
    final int NUMERO = (int) (Math.random() * 1000000);
    return new Conta(agencia, saldo, NUMERO);
  }
}
