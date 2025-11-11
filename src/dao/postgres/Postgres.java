package dao.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgres {
    private static final Postgres instance = new Postgres();

    private String url = "jdbc:postgresql://localhost:15432/projeto_vendas_online";
    private String user = "postgres";
    private String password = "admin";

    private static Connection connection;

    private Postgres() {};

    public static Postgres getInstance() {
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if(connection == null) {
            connection = initConnection();
            System.out.println("Connection to the bank established.");
            return connection;
        } else if(connection.isClosed()) {
            connection = initConnection();
            return connection;
        }
        return null;
    }

    private Connection initConnection() {
        try{
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
