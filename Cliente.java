import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Cliente {
  private Integer id;
  private String nome;
  private String cpf;
  private ArrayList<Conta> contas;
  private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
  // atributos privates
  public Cliente(String nome, String cpf) {
    this.id = ID_GENERATOR.getAndIncrement();
    this.nome = nome;
    this.cpf = cpf;
    this.contas = new ArrayList<Conta>();
  }

  @Override
  public String toString() {
    return "Cliente{"
        + "id=" + id + ", nome='" + nome + '\'' + ", cpf='" + cpf + '\'' + '}';
  }
  public void addConta(Conta conta) { this.contas.add(conta); }
  public String contasToString() {
    String contasString = "";
    for (int i = 0; i < this.contas.size(); i++) {
      contasString += i + " - " + this.contas.get(i).toString() + "\n";
    }
    return contasString;
  }
  public ArrayList<Conta> getContas() { return this.contas; }
  public Integer getId() { return this.id; }
  public String getNome() { return this.nome; }
  public String getCpf() { return this.cpf; }
}
