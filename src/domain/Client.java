package domain;

public class Client {
    Integer id;
    String name;
    String cpf;
    Float yers;

    public Client() {};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client(String name, String cpf, Float yers) {
        this.name = name;
        this.cpf = cpf;
        this.yers = yers;
    };

    public Float getYers() {
        return yers;
    }

    public void setYers(Float yers) {
        this.yers = yers;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*
id bigint not null,
name varchar(50) not null,
cpf varchar(11) not null unique,
yers int not null check (yers >= 18),
constraint pk_client_id primary key (id)
 */