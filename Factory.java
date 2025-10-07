public class Factory {
    public Cliente createCliente(String nome, String cpf) {
        return new Cliente(nome, cpf);
    }
}
