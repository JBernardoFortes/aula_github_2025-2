
public class Conta {
  private int agencia;
  private double saldo;
  private int numero;

  public Conta(int agencia, double saldo, int numero) {
    this.agencia = agencia;
    this.saldo = saldo;
    this.numero = numero;
  }
@Override
  public String toString() {
      return "Conta{" + "agencia=" + agencia + ", saldo=" + saldo + ", numero=" + numero + '}';
  }
  public Integer getAgencia() { return this.agencia; }
  public Double getSaldo() { return this.saldo; }
  public Integer getNumero() { return this.numero; }
}
