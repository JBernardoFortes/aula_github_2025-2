
public class Conta {
  private int agencia;
  private int saldo;
  private int numero;

  public Conta(int agencia, int saldo, int numero) {
    this.agencia = agencia;
    this.saldo = saldo;
    this.numero = numero;
  }
  public Integer getAgencia() { return this.agencia; }
  public Integer getSaldo() { return this.saldo; }
  public Integer getNumero() { return this.numero; }
}
