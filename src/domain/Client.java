package domain;

public class Client {
    String name;
    String cpf;
    Integer yers;

    public Client() {};

    public Client(String name, String cpf, Integer yers) {
        this.name = name;
        this.cpf = cpf;
        this.yers = yers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setYers(Integer yers) {
        this.yers = yers;
    }

    public Integer getYers() {
        return yers;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", yers=" + yers +
                '}';
    }
}
