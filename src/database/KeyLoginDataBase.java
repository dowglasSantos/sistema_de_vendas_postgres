package database;

public class KeyLoginDataBase {

    public String getUrl() {
        return "jdbc:postgresql://localhost:15432/projeto_vendas_online";
    }

    public String getUser() {
        return "postgres";
    }

    public String getPassword() {
        return "admin";
    }
}
