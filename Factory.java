public class Factory {
  public Cliente createCliente(String nome, String cpf) {
    return new Cliente(nome, cpf);
  }
  public Conta createConta(int agencia, int saldo, int numero) {
    return new Conta(agencia, saldo, numero);
  }
}
