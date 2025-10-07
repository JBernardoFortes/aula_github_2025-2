import java.util.concurrent.atomic.AtomicInteger;

public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    //atributos privates
    public Cliente(String nome, String cpf){
        this.id = ID_GENERATOR.getAndIncrement();
        this.nome = nome;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
//funções do cliente
}
